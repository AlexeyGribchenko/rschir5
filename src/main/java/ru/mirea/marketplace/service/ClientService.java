package ru.mirea.marketplace.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mirea.marketplace.DTO.Client;

import java.util.List;

public interface ClientService {

    Client getOne(Integer id);

    List<Client> getAll();

    void create(Client client);

    boolean update(Integer id, Client client);

    void delete(Integer id);
}
