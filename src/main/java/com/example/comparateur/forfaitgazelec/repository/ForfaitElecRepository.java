package com.example.comparateur.forfaitgazelec.repository;

import com.example.comparateur.forfaitgazelec.entity.ForfaitE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface ForfaitElecRepository extends JpaRepository<ForfaitE, UUID> {
    Optional<ForfaitE> findById(UUID id);
}
