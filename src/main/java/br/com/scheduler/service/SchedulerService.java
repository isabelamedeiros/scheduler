package br.com.scheduler.service;

import br.com.scheduler.dto.SchedulerDTO;
import br.com.scheduler.model.Scheduler;
import br.com.scheduler.repository.SchedulerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

        return repository.save(scheduler);
    }
}
