// Сервис, который шлёт сообщения в Kafka

package org.example.producer.service;

import org.example.producer.model.TaskRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TaskProducerService {

    private static final String TOPIC = "tasks.requests";

    private final KafkaTemplate<String, TaskRequest> kafkaTemplate;

    public TaskProducerService(KafkaTemplate<String, TaskRequest> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(TaskRequest request) {
        kafkaTemplate.send(TOPIC, request.getTaskId(), request);
    }
}
