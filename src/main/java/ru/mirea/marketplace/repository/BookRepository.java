package ru.mirea.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.marketplace.DTO.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
