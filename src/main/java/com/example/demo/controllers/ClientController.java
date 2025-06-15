package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Client;
import com.example.demo.services.ClientService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientService clientService;
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/add")
    public Client addClient(@RequestBody Client client) {
        Client newClient = clientService.addClient(client);
        System.out.println("Client was called");
        return newClient;
    }
    @GetMapping("/get/{id}")
    public Client getMethodName(@PathVariable Long id) {
        Optional<Client> client = clientService.getClientByid(id);
        return client.get();
    }
    
    

}
