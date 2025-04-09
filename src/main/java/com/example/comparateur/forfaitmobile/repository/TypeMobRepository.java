package com.example.comparateur.forfaitmobile.repository;


import com.example.comparateur.forfaitmobile.entity.TypeM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TypeMobRepository extends JpaRepository<TypeM, UUID> {

    Optional<TypeM> findByTypeMid(UUID typeMid);

    boolean existsByTypeMid(UUID typeMid);

    void deleteByTypeMid(UUID typeMid);
}
