package br.com.scheduler.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transfer_scheduling")
public class Scheduler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "A conta de origem é obrigatória.")
    @Size(min = 10, max = 10, message = "A conta deve ter 10 dígitos.")
    @Column(name = "origin_account", nullable = false)
    private String originAccount;

    @NotNull(message = "A conta de destino é obrigatória.")
    @Size(min = 10, max = 10, message = "A conta deve ter 10 dígitos.")
    @Column(name = "destination_account", nullable = false)
    private String destinationAccount;

    @NotNull(message = "O valor da transferência é obrigatório.")
    @Column(name = "transfer_value", nullable = false)
    private BigDecimal transferValue;

    @Column(name = "tax")
    private BigDecimal tax;

    @NotNull(message = "A data de transferência é obrigatória.")
    @Column(name = "transfer_date", nullable = false)
    private LocalDate transferDate;

    @NotNull(message = "A data de agendamento é obrigatória.")
    @Column(name = "scheduling_date", nullable = false)
    private LocalDate schedulingDate;
}