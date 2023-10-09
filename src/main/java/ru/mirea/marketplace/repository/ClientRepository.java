package ru.mirea.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.marketplace.DTO.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
