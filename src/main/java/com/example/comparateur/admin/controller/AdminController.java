package com.example.comparateur.admin.controller;


import com.example.comparateur.admin.entity.Admin;
import com.example.comparateur.admin.mapper.AdminMapper;
import com.example.comparateur.admin.service.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;
    private final AdminMapper adminMapper;

    public AdminController(AdminService adminService, AdminMapper adminMapper) {
        this.adminService = adminService;
        this.adminMapper = adminMapper;
    }
    @GetMapping("/getbyid")
    public Admin getAdminById(@RequestParam("id") UUID id) {
        return adminService.getAdminById(id);
    }
    @GetMapping("/get")
    public List<Admin> getAdmins() {
        return adminService.getAllAdmins();
    }
    @PostMapping("/create")
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.saveAdmin(admin);
    }
}
