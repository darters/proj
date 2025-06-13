package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.repositories.ClientRepository;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    
}
