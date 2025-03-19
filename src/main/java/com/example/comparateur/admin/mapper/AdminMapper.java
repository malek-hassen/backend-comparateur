package com.example.comparateur.admin.mapper;


import com.example.comparateur.admin.dto.AdminDto;
import com.example.comparateur.admin.entity.Admin;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper {
    public Admin toDto(Admin admin) {
        if (admin == null) {
            return null;
        }
        Admin adminDto = new Admin();
        adminDto.setId(admin.getId());
        adminDto.setUsername(admin.getUsername());
        adminDto.setMail(admin.getMail());
        adminDto.setPassword(admin.getPassword());
        adminDto.setRole(admin.getRole());
        return adminDto;
    }
    public Admin toEntity(AdminDto adminDto) {
        if (adminDto == null) {
            return null;
        }
        Admin admin = new Admin();
        admin.setId(adminDto.getId());
        admin.setMail(adminDto.getMail());
        admin.setUsername(adminDto.getUsername());
        admin.setPassword(adminDto.getPassword());
        admin.setRole(adminDto.getRole());
        return admin;
    }
}
