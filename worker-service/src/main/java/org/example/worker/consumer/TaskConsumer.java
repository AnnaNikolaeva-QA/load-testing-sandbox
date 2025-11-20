package org.example.worker.consumer;

import org.example.worker.model.TaskRequest;
import org.example.worker.service.TaskProcessingService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TaskConsumer {

    private final TaskProcessingService processingService;

    public TaskConsumer(TaskProcessingService processingService) {
        this.processingService = processingService;
    }

    @KafkaListener(
            topics = "tasks.requests",
            groupId = "worker-group",
            containerFactory = "taskKafkaListenerFactory"
    )
    public void consume(TaskRequest request) {
        processingService.process(request);
    }
}
