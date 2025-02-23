package br.com.scheduler.service;

import br.com.scheduler.dto.SchedulerDTO;
import br.com.scheduler.model.Scheduler;
import br.com.scheduler.repository.SchedulerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class SchedulerService {

    @Autowired
    private SchedulerRepository repository;

    public List<Scheduler> listTransfers() {
        return repository.findAll();
    }

    public Scheduler createTransfer(SchedulerDTO schedulerDTO) {
        Scheduler scheduler = new Scheduler();
        scheduler.setOriginAccount(schedulerDTO.getOriginAccount());
        scheduler.setDestinationAccount(schedulerDTO.getDestinationAccount());
        scheduler.setTransferValue(schedulerDTO.getTransferValue());
        scheduler.setTransferDate(schedulerDTO.getTransferDate());
        scheduler.setSchedulingDate(LocalDate.now());

        BigDecimal tax = calculateTax(scheduler.getTransferDate(), scheduler.getTransferValue());
        scheduler.setTax(tax);

        return repository.save(scheduler);
    }

    private BigDecimal calculateTax(LocalDate transferDate, BigDecimal transferValue) {
        long days = ChronoUnit.DAYS.between(LocalDate.now(), transferDate);
        if (days == 0) return transferValue.multiply(BigDecimal.valueOf(0.025)).add(BigDecimal.valueOf(3.00));
        if (days >= 1 && days <= 10) return BigDecimal.valueOf(12.00);
        if (days >= 11 && days <= 20) return transferValue.multiply(BigDecimal.valueOf(0.082));
        if (days >= 21 && days <= 30) return transferValue.multiply(BigDecimal.valueOf(0.069));
        if (days >= 31 && days <= 40) return transferValue.multiply(BigDecimal.valueOf(0.047));
        if (days >= 41 && days <= 50) return transferValue.multiply(BigDecimal.valueOf(0.017));
        throw new IllegalArgumentException("Data de transferência inválida");
    }

}
