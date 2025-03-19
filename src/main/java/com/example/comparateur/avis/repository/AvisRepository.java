package com.example.comparateur.avis.repository;


import com.example.comparateur.avis.entity.Avis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AvisRepository extends CrudRepository<Avis, UUID> {

}
