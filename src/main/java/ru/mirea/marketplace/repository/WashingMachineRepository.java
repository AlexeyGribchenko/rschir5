package ru.mirea.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.marketplace.DTO.WashingMachine;

@Repository
public interface WashingMachineRepository extends JpaRepository<WashingMachine, Integer> {
}
