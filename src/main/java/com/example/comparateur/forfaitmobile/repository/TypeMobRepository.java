package com.example.comparateur.forfaitmobile.repository;


import com.example.comparateur.forfaitmobile.entity.TypeM;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TypeMobRepository extends JpaRepository<TypeM, UUID> {
    Page<TypeM> findByTypeMid(Pageable pageable, UUID typeMid);

    Optional<TypeM> findByTypeMid(UUID typeMid);

    // Check if a TypeM exists by ID
    boolean existsByTypeMid(UUID typeMid);

    // Delete by ID (JpaRepository already provides deleteById)
    void deleteByTypeMid(UUID typeMid);
}
