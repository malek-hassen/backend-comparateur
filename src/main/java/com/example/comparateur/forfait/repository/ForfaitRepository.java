package com.example.comparateur.forfait.repository;

import com.example.comparateur.forfait.entity.Forfait;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface ForfaitRepository extends JpaRepository<Forfait, UUID>  {
    boolean existsByTitle(String title);
}
