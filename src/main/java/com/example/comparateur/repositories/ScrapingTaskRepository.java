package com.example.comparateur.repositories;

import com.example.comparateur.classes.ScrapingTask;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ScrapingTaskRepository extends JpaRepository<ScrapingTask, Long> {
}