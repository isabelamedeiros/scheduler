package br.com.scheduler.config;

import lombok.Data;

@Data
public class ErrorResponse {
    private String message;
    private int status;
    private String path;

}
