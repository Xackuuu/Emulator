package ru.pflb.emulator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.pflb.emulator.model.dto.ClientDto;
import ru.pflb.emulator.service.ClientService;

@RestController
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<ClientDto> getClient(@PathVariable long id) {
        ClientDto client = clientService.getUserById(id);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/client/{id}")
    public ResponseEntity<ClientDto> deleteClient(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/client/{id}")
    public ResponseEntity<ClientDto> updateClient(@RequestBody ClientDto client) {
        return ResponseEntity.ok(client);
    }

    @PostMapping("/client/{id}")
    public ResponseEntity<ClientDto> addClient(@Validated @RequestBody ClientDto client) {
        return ResponseEntity.status(201).build();
    }

}
