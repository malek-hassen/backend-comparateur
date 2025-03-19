package com.example.comparateur.admin.repository;

import com.example.comparateur.admin.entity.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AdminRepository extends CrudRepository<Admin, UUID> {

    Optional<Admin> findByUsername(String username);
}
