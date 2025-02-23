package br.com.scheduler.controller;

import br.com.scheduler.dto.SchedulerDTO;
import br.com.scheduler.model.Scheduler;
import br.com.scheduler.service.SchedulerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/scheduler")
@Tag(name = "Scheduler", description = "API para agendamento de transferências financeiras")
public class SchedulerController {

    @Autowired
    private SchedulerService service;

    @GetMapping
    @Operation(summary = "Listar transferências financeiras", description = "Retorna a lista de todas as transferências financeiras agendadas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de transferências financeiras retornada com sucesso")
    })
    public List<Scheduler> listTransfers() {
        return service.listTransfers();
    }

    @PostMapping
    @Operation(summary = "Agendar uma transferência financeira", description = "Cria um novo agendamento de transferências financeiras.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transferência agendada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public Scheduler scheduleTransfer(@Valid @RequestBody SchedulerDTO schedulerDTO) {
        return service.createTransfer(schedulerDTO);
    }
}