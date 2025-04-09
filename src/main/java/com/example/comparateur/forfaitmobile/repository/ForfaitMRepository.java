package com.example.comparateur.forfaitmobile.repository;

import com.example.comparateur.forfait.repository.ForfaitRepository;
import com.example.comparateur.forfaitmobile.entity.ForfaitM;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface ForfaitMRepository extends JpaRepository<ForfaitM, UUID>  {

        Optional<ForfaitM> findById(UUID id);

        boolean existsById(UUID id);

}

