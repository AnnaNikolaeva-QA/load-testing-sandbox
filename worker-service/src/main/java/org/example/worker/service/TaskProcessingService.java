// обработка нагрузки
package org.example.worker.service;

import org.example.worker.model.TaskRequest;
import org.springframework.stereotype.Service;

@Service
public class TaskProcessingService {

    public void process(TaskRequest request) {

        long start = System.currentTimeMillis();

        switch (request.getProcessingType()) {
            case "CPU" -> cpuWork(request.getComplexity());
            case "IO"  -> sleep(request.getProcessingTimeMs());
            case "MIX" -> {
                cpuWork(request.getComplexity());
                sleep(request.getProcessingTimeMs());
            }
            default -> sleep(50);
        }

        long duration = System.currentTimeMillis() - start;
        System.out.println("Processed task " + request.getTaskId() + " in " + duration + " ms");
    }

    private void cpuWork(int complexity) {
        long sum = 0;
        for (long i = 0; i < complexity * 1_000_00L; i++) {
            sum += i;
        }
    }

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
