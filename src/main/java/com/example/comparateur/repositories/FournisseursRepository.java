package com.example.comparateur.repositories;

import com.example.comparateur.classes.Fournisseurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FournisseursRepository extends JpaRepository<Fournisseurs, Long> {
}
