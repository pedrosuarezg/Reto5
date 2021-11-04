package com.usa.ciclo3.retociclo3.service;

import com.usa.ciclo3.retociclo3.model.Category;
import com.usa.ciclo3.retociclo3.model.Client;
import com.usa.ciclo3.retociclo3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    public ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save(Client client){
        if (client.getIdClient() == null) {
            return clientRepository.save(client);
        } else {
            Optional<Client> tmpClient = clientRepository.getClient(client.getIdClient());
            if (tmpClient.isEmpty()) {
                return clientRepository.save(client);
            } else {
                return client;
            }
        }
    }

    public Client update(Client client){
             if (client.getIdClient() != null) {
                Optional<Client> e = clientRepository.getClient(client.getIdClient());
                if (!e.isEmpty()) {
                    if (client.getEmail() != null) {
                        e.get().setEmail(client.getEmail());
                    }
                    if (client.getPassword() != null) {
                        e.get().setPassword(client.getPassword());
                    }
                    if (client.getName() != null) {
                        e.get().setName(client.getName());
                    }
                    if (client.getAge() != null) {
                        e.get().setAge(client.getAge());
                    }
                    clientRepository.save(e.get());
                    return e.get();

                } else {
                    return client;
                }
            } else {
                return client;
            }
    }

    public boolean deleteClient(int id){
        Boolean aBoolean = getClient(id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
