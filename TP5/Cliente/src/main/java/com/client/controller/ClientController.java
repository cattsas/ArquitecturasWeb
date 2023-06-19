package com.client.controller;

import com.client.model.Client;
import com.client.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Api(tags = "Clients", description = "Servicio de clientes")
public class ClientController {
    @Qualifier("clientService")
    @Autowired
    private ClientService service;

    public ClientController(@Qualifier("clientService") ClientService service) {
        super();
        this.service = service;
    }

    //metodos para controller
    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return service.getClient();
    }

    @PostMapping("/clients")
    public Client newClient(@RequestBody Client p) {
        return service.newClient(p);
    }
    //devolveria un listado de clientes

    @PutMapping("/clients/{id}")
    Client modifyClient(@RequestBody Client clientUpdated, @PathVariable Integer id) {
        return service.updateClient(clientUpdated, id);
    }

    @GetMapping("/clients/{id}")
    Client getClient(@PathVariable Integer id) {
        return service.getClient(id);
    }

    //REVISAR --> deberia de devolver alguna respuesta andan las dos pero sin respuesta
   // @DeleteMapping("/clients/{id}")
   // public void deleteClient(@PathVariable("id") Integer id) {
   //     service.deleteClient(id);
   // }
    @DeleteMapping("/clients/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable(value="id")int id) {
        service.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

