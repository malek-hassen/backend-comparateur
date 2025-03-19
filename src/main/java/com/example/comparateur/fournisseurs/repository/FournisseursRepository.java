package com.example.comparateur.fournisseurs.repository;

import com.example.comparateur.fournisseurs.entity.Fournisseurs;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface FournisseursRepository extends CrudRepository<Fournisseurs, UUID> {
    Optional<Fournisseurs> findById(UUID founisseurId);
}
