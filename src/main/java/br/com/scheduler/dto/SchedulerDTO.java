package br.com.scheduler.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data

public class SchedulerDTO {
    private String originAccount;
    private String destinationAccount;
    private BigDecimal transferValue;
    private LocalDate transferDate;
}