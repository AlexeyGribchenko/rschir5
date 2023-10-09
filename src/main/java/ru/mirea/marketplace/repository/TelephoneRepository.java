package ru.mirea.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.marketplace.DTO.Telephone;

@Repository
public interface TelephoneRepository extends JpaRepository<Telephone, Integer> {
}
