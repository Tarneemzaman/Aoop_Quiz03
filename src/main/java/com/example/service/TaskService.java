package com.example.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Async("taskExecutor")
    public void executeTask(int id) {
        System.out.println("Start Task " + id + " on " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Task " + id + " was interrupted");
        }
        System.out.println("End Task " + id);
    }
}
