package com.example.comparateur.forfait.repository;

import com.example.comparateur.forfait.entity.Forfait;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface ForfaitRepository extends CrudRepository<Forfait, UUID> {
}
