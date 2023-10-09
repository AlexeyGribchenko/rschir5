package ru.mirea.marketplace.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mirea.marketplace.DTO.Client;
import ru.mirea.marketplace.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getOne(@PathVariable Integer id) {
        Client client = clientService.getOne(id);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }

    @GetMapping()
    public ResponseEntity<List<Client>> getAll() {
        List<Client> clients = clientService.getAll();
        return ResponseEntity.ok(clients);
    }

    @PostMapping()
    public ResponseEntity<Void> create(@RequestBody Client client) {
        clientService.create(client);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Client client) {
        if(clientService.update(id, client)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
