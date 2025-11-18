package com.example.Day7.exception;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDateTime;
import java.util.Map;

@JsonPropertyOrder({"timestamp", "status", "error", "path", "details"})
public class ApiError {

    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String path;
    private Map<String, String> details;

    public ApiError(int status, String error, String path, Map<String, String> details) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.path = path;
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }

    public Map<String, String> getDetails() {
        return details;
    }
}
