//package com.example.comparateur.admin.service;
//
//import com.example.comparateur.admin.repository.AdminRepository;
//import org.springframework.context.annotation.Primary;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//@Primary
//public class AdminDetailsService implements UserDetailsService {
//
//
//    private AdminRepository adminRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return adminRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("Admin not found"));
//    }
//}
//
