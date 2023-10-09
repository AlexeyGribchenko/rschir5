package ru.mirea.marketplace.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mirea.marketplace.DTO.WashingMachine;
import ru.mirea.marketplace.service.WashingMachineService;

import java.util.List;

@RestController
@RequestMapping("/api/washing_machine")
public class WashingMachineController {

    private final WashingMachineService washingMachineService;

    public WashingMachineController(WashingMachineService washingMachineService) {
        this.washingMachineService = washingMachineService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<WashingMachine> getOne(@PathVariable Integer id) {
        WashingMachine washingMachine = washingMachineService.getOne(id);
        if (washingMachine == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(washingMachine);
    }

    @GetMapping()
    public ResponseEntity<List<WashingMachine>> getAll() {
        List<WashingMachine> washingMachines = washingMachineService.getAll();
        return ResponseEntity.ok(washingMachines);
    }


    @PostMapping()
    public ResponseEntity<Void> create(@RequestBody WashingMachine washingMachine) {
        washingMachineService.create(washingMachine);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody WashingMachine washingMachine) {
        if(washingMachineService.update(id, washingMachine)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        washingMachineService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
