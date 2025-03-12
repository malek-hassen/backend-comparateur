//package com.example.comparateur;
//
//
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//
//@Component("privilegeService") // Important for Spring Security SpEL
//public class PrivilegeService {
//
//    public boolean hasPrivilege(String domain, String entity, String action) {
//        //  Get the current user's roles
//        var authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if (authentication == null || !authentication.isAuthenticated()) {
//            return false; // User is not authenticated
//        }
//
//        // Extract the user's roles/privileges (Replace this logic based on your app)
//        var authorities = authentication.getAuthorities();
//        String requiredPrivilege = domain + "_" + entity + "_" + action; // Example: "MANAGEMENT_BUILDINGS_READ"
//
//        //  Check if the user has the required privilege
//        return authorities.stream()
//                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(requiredPrivilege));
//    }
//}
