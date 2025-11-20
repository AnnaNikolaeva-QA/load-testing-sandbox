package org.example.worker.model;
// DTO для запроса
// передлать на lombok
public class TaskRequest {

    private String taskId;          // будем генерировать на стороне producer
    private int payloadSize;        // размер нагрузки в байтах (для игры)
    private String processingType;  // "CPU", "IO", "MIX"
    private long processingTimeMs;  // желаемое время обработки
    private int complexity;         // условная "сложность"

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public int getPayloadSize() {
        return payloadSize;
    }

    public void setPayloadSize(int payloadSize) {
        this.payloadSize = payloadSize;
    }

    public String getProcessingType() {
        return processingType;
    }

    public void setProcessingType(String processingType) {
        this.processingType = processingType;
    }

    public long getProcessingTimeMs() {
        return processingTimeMs;
    }

    public void setProcessingTimeMs(long processingTimeMs) {
        this.processingTimeMs = processingTimeMs;
    }

    public int getComplexity() {
        return complexity;
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }
}
