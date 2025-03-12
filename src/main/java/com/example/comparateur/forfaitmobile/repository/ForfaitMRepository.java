package com.example.comparateur.forfaitmobile.repository;

import com.example.comparateur.forfaitmobile.dto.ForfaitMobileDTO;
import com.example.comparateur.forfaitmobile.entity.ForfaitM;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ForfaitMRepository extends JpaRepository<ForfaitM, UUID> {
        Page<ForfaitM> findById(UUID id, Pageable pageable);
        void deleteById(UUID id);

}
