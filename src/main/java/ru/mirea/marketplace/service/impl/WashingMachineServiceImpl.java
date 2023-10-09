package ru.mirea.marketplace.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mirea.marketplace.DTO.WashingMachine;
import ru.mirea.marketplace.repository.WashingMachineRepository;
import ru.mirea.marketplace.service.WashingMachineService;

import java.util.List;
import java.util.Optional;

@Service
public class WashingMachineServiceImpl implements WashingMachineService {

    private final WashingMachineRepository washingMachineRepository;

    public WashingMachineServiceImpl(WashingMachineRepository washingMachineRepository) {
        this.washingMachineRepository = washingMachineRepository;
    }

    public WashingMachine getOne(@PathVariable Integer id) {
        return this.washingMachineRepository.findById(id).orElse(null);
    }

    public List<WashingMachine> getAll() {
        return this.washingMachineRepository.findAll();
    }

    public void create(@RequestBody WashingMachine washingMachine) {
        this.washingMachineRepository.saveAndFlush(washingMachine);
    }

    public boolean update(Integer id, WashingMachine washingMachine) {
        Optional<WashingMachine> optionalWashingMachine = washingMachineRepository.findById(id);
        if (optionalWashingMachine.isPresent()) {
            WashingMachine oldWashingMachine = optionalWashingMachine.get();
            oldWashingMachine.setProducer(washingMachine.getProducer());
            oldWashingMachine.setTankVolume(washingMachine.getTankVolume());
            oldWashingMachine.setTitle(washingMachine.getTitle());
            oldWashingMachine.setSellerId(washingMachine.getSellerId());
            oldWashingMachine.setProductType(washingMachine.getProductType());
            oldWashingMachine.setPrice(washingMachine.getPrice());
            this.washingMachineRepository.saveAndFlush(oldWashingMachine);
            return true;
        }
        return false;
    }

    public void delete(@RequestParam Integer id) {
        this.washingMachineRepository.deleteById(id);
    }
}
