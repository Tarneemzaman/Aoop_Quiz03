package com.example.runner;

import com.example.service.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TaskRunner implements CommandLineRunner {

    private final TaskService taskService;

    public TaskRunner(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== Starting Async Tasks ===");
        taskService.executeTask(1);
        taskService.executeTask(2);
        taskService.executeTask(3);
        System.out.println("=== All tasks submitted ===");
        
        // Give tasks time to complete
        Thread.sleep(3000);
        System.out.println("=== All tasks completed ===");
    }
}
