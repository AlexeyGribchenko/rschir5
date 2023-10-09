package ru.mirea.marketplace.service;

import ru.mirea.marketplace.DTO.WashingMachine;

import java.util.List;

public interface WashingMachineService {

    WashingMachine getOne(Integer id);

    List<WashingMachine> getAll();

    void create(WashingMachine washingMachine);

    boolean update(Integer id, WashingMachine washingMachine);

    void delete(Integer id);
}
