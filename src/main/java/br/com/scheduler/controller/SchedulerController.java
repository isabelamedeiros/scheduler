package br.com.scheduler.controller;

import br.com.scheduler.dto.SchedulerDTO;
import br.com.scheduler.model.Scheduler;
import br.com.scheduler.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scheduler")
public class SchedulerController {

    @Autowired
    private SchedulerService service;

    @GetMapping
    public List<Scheduler> listTransfers() {
        return service.listTransfers();
    }

    @PostMapping
    public Scheduler scheduleTransfer(@RequestBody SchedulerDTO schedulerDTO) {
        return service.createTransfer(schedulerDTO);
    }
}