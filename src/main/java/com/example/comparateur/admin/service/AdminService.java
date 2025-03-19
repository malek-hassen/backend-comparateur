package com.example.comparateur.admin.service;


import com.example.comparateur.admin.entity.Admin;
import com.example.comparateur.admin.mapper.AdminMapper;
import com.example.comparateur.admin.repository.AdminRepository;
import com.example.comparateur.forfaitgazelec.entity.ForfaitE;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;

    public AdminService(AdminRepository adminRepository, AdminMapper adminMapper) {
        this.adminRepository = adminRepository;
        this.adminMapper = adminMapper;
    }

    public List<Admin> getAllAdmins() {
        List<Admin> forfaits = new ArrayList<>();
        adminRepository.findAll().forEach(forfaits::add);  // Convert Iterable to List
        return forfaits.stream()
                .map(adminMapper::toDto)
                .toList();
    }

    public Admin getAdminById(UUID id) {
        return adminRepository.findById(id).orElse(null);
    }

    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public void deleteAdmin(UUID id) {
        adminRepository.deleteById(id);
    }
}
