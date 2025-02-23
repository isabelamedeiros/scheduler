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
@Table(name = "transfer_scheduling", schema = "sch")
public class Scheduler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "origin_account")
    private String originAccount;

    @Column(name = "destination_account")
    private String destinationAccount;

    @Column(name = "value")
    private BigDecimal value;

    @Column(name = "tax")
    private BigDecimal tax;

    @Column(name = "transfer_date")
    private LocalDate transferDate;

    @Column(name = "scheduling_date")
    private LocalDate schedulingDate;
}