// REST-контроллер

package org.example.producer.controller;

import org.example.producer.model.TaskRequest;
import org.example.producer.service.TaskProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskProducerService taskProducerService;

    public TaskController(TaskProducerService taskProducerService) {
        this.taskProducerService = taskProducerService;
    }

    @PostMapping
    public ResponseEntity<String> createTask(@RequestBody TaskRequest request) {
        // taskId на стороне producer
        String taskId = UUID.randomUUID().toString();
        request.setTaskId(taskId);

        taskProducerService.send(request);

        return ResponseEntity.ok(taskId);
    }
}
