package ru.mirea.marketplace.service;

import ru.mirea.marketplace.DTO.Telephone;

import java.util.List;

public interface TelephoneService {

    Telephone getOne(Integer id);

    List<Telephone> getAll();
    void create(Telephone telephone);
    boolean update(Integer id, Telephone telephone);
    void delete(Integer id);
}
