package com.example.comparateur.forfaitmob;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ForfaitMobileRepository extends CrudRepository<ForfaitMobile, UUID> {
    List<ForfaitMobile> findForfaitMobilesById(UUID id);
}
