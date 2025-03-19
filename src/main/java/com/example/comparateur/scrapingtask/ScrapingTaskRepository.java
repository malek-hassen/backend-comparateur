package com.example.comparateur.scrapingtask;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ScrapingTaskRepository extends JpaRepository<ScrapingTask, Long> {
}