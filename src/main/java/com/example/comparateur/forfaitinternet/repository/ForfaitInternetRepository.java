package com.example.comparateur.forfaitinternet.repository;

import com.example.comparateur.forfaitinternet.entity.ForfaitInternet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

@Repository


public interface ForfaitInternetRepository extends JpaRepository<ForfaitInternet, UUID> {
    Optional<ForfaitInternet> findById(UUID id);
}


