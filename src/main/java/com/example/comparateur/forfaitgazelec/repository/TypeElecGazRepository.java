package com.example.comparateur.forfaitgazelec.repository;

import com.example.comparateur.forfaitgazelec.entity.TypeGE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface TypeElecGazRepository extends JpaRepository<TypeGE, UUID> {
    Optional<TypeGE> findByid(UUID id);
}
