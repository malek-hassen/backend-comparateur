package com.example.comparateur;
import com.example.comparateur.admin.entity.Admin;
import com.example.comparateur.admin.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Service

public class CustomUserDetailsService implements UserDetailsService {


    private final AdminRepository adminRepository;
    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);


    public CustomUserDetailsService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByUsername(username)
                .orElseThrow(() -> {
                    logger.warn("User not found: " + username);
                    return new UsernameNotFoundException("User not found");
                });
        logger.info("Admin found: " + admin.getUsername());
        return admin;
    }

}


