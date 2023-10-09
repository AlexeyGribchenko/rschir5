package ru.mirea.marketplace.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mirea.marketplace.DTO.Client;
import ru.mirea.marketplace.repository.ClientRepository;
import ru.mirea.marketplace.service.ClientService;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client getOne(Integer id) {
        return this.clientRepository.findById(id).orElse(null);
    }

    public List<Client> getAll() {
        return this.clientRepository.findAll();
    }

    public void create(Client client) {
        this.clientRepository.saveAndFlush(client);
    }

    public boolean update(Integer id, Client client) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client oldClient = optionalClient.get();
            oldClient.setName(client.getName());
            oldClient.setEmail(client.getEmail());
            oldClient.setLogin(client.getLogin());
            oldClient.setPassword(client.getPassword());
            clientRepository.saveAndFlush(oldClient);
            return true;
        }
        return false;

    }

    public void delete(Integer id) {
        this.clientRepository.deleteById(id);
    }
}
