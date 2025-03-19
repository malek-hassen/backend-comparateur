package com.example.comparateur.forfaitinternet.repository;

import com.example.comparateur.forfaitinternet.entity.ForfaitInternet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository


public interface ForfaitInternetRepository extends CrudRepository<ForfaitInternet, UUID> {

    Optional<ForfaitInternet> findById(UUID id);
}


