package com.example.comparateur;

import com.example.comparateur.admin.entity.Admin;
import com.example.comparateur.admin.repository.AdminRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {



    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final AdminRepository adminRepository;
    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, PasswordEncoder passwordEncoder, AdminRepository adminRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
        this.adminRepository = adminRepository;

    }
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);


    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> request) {
        Map<String, String> response = new HashMap<>();
        try {
            logger.info("Authenticating user: " + request.get("username"));
        // Authenticate user
            Authentication authentication = authenticationManager.authenticate
                            (new UsernamePasswordAuthenticationToken(request.get("username"), request.get("password")));


            logger.info("User authenticated successfully");
            // Get authenticated user
            logger.info("[DEBUG] Retrieving admin details from authentication principal");
            Object principal = authentication.getPrincipal();
            logger.info("[DEBUG] Principal object type: " + principal.getClass().getName());
            logger.info("[DEBUG] Principal object: " + principal);

// Attempt to cast the Principal to Admin
            Admin adminDetails = (Admin) principal;
            logger.info("[DEBUG] Admin details: " + adminDetails);
            // Generate JWT Token
            String token = jwtUtil.generateToken(adminDetails.getUsername());
            logger.info("JWT Token generated: " + token);
            // Prepare response

            response.put("token", token);
            response.put("username", adminDetails.getUsername());
            response.put("role", adminDetails.getAuthorities().iterator().next().getAuthority());

            return ResponseEntity.ok(response);
        } catch (BadCredentialsException e) {
            response.put("error", "Invalid credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);

        } catch (Exception e) {
            response.put("error", "Authentication failed");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @PostMapping("/register")
    public String register(@RequestBody Map<String, String> request) {
        Admin admin = new Admin();
        admin.setUsername(request.get("username"));
        admin.setPassword(passwordEncoder.encode(request.get("password")));
        admin.setRole("ADMIN");
        adminRepository.save(admin);
        return "User registered successfully";
    }

}
