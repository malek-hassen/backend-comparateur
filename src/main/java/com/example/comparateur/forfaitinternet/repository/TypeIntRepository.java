package com.example.comparateur.forfaitinternet.repository;

import com.example.comparateur.forfaitinternet.entity.TypeInternet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TypeIntRepository extends CrudRepository<TypeInternet, UUID> {
    Page<TypeInternet> findByid(Pageable pageable, UUID id);

    Optional<TypeInternet> findByid(UUID id);

}

