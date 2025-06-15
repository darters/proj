package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Client;
import com.example.demo.repositories.ClientRepository;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client addClient(Client client) {
        if (clientRepository.findByEmail(client.getEmail()).isPresent()) {
            throw new IllegalArgumentException(client.getEmail() + " already exists");
        }
        return clientRepository.save(client);
    }
    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }
    public Optional<Client> getClientByid(Long id) {
        return clientRepository.findById(id);
    }
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
    
}
