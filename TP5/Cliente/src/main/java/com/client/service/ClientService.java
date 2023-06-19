package com.client.service;

import com.client.model.Client;
import com.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;


    public Client newClient(Client c) {
        return clientRepository.save(c);
    }

    public List<Client> getClient(){
        return clientRepository.findAll();
    }

    public Client getClient(Integer id) { 
        return clientRepository.findAllById(Collections.singleton(id)).get(0);
    }

    public Client updateClient(Client clientUpdated, Integer id) {
        Client client = clientRepository.getReferenceById(id);
        client.setName(clientUpdated.getName());
        client.setLastname(clientUpdated.getLastname());
        return clientRepository.save(client);
    }

    public void deleteClient(int id) { clientRepository.deleteById(id); }

}
