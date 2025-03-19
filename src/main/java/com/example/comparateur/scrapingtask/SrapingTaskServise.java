package com.example.comparateur.scrapingtask;

import com.example.comparateur.scrapingtask.ScrapingTaskRepository;
import com.example.comparateur.scrapingtask.ScrapingTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SrapingTaskServise {
    @Autowired
    private ScrapingTaskRepository scrapingTaskRepository;

    public List<ScrapingTask> getAllScrapingTasks() {
        return scrapingTaskRepository.findAll();
    }

    public ScrapingTask getScrapingTaskById(Long id) {
        return scrapingTaskRepository.findById(id).orElse(null);
    }

    public ScrapingTask saveScrapingTask(ScrapingTask scrapingTask) {
        return scrapingTaskRepository.save(scrapingTask);
    }

    public void deleteScrapingTask(Long id) {
        scrapingTaskRepository.deleteById(id);
    }

}
