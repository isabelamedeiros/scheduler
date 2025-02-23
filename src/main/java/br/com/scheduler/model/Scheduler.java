package br.com.scheduler.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transfer_scheduling")
public class Scheduler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "origin_account", nullable = false)
    private String originAccount;

    @Column(name = "destination_account", nullable = false)
    private String destinationAccount;

    @Column(name = "transfer_value", nullable = false)
    private BigDecimal transferValue;

    @Column(name = "tax")
    private BigDecimal tax;

    @Column(name = "transfer_date", nullable = false)
    private LocalDate transferDate;

    @Column(name = "scheduling_date", nullable = false)
    private LocalDate schedulingDate;
}