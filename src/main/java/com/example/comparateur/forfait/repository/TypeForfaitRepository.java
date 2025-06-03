package com.example.comparateur.forfait.repository;

import com.example.comparateur.forfait.entity.TypeForfait;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface TypeForfaitRepository extends JpaRepository<TypeForfait, UUID> {
    Optional<TypeForfait> findByid(UUID id);

    boolean existsById(UUID id);

    void deleteById(UUID id);


}
