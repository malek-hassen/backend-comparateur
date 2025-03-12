package com.example.comparateur.forfaitgazelec.repository;

import com.example.comparateur.forfaitgazelec.entity.ForfaitG;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ForfaitGazRepository extends JpaRepository<ForfaitG, UUID> {

    Optional<ForfaitG> findById(UUID id);


}
