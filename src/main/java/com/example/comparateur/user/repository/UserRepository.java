package com.example.comparateur.user.repository;

import com.example.comparateur.user.entity.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
    public interface UserRepository extends CrudRepository<AppUser, UUID> {}