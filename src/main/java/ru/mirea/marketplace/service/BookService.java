package ru.mirea.marketplace.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mirea.marketplace.DTO.Book;

import java.util.List;

public interface BookService {

    Book getOne(Integer id);
    List<Book> getAll();

    void create(Book book);

    boolean update(Integer id, Book book);

    void delete(Integer id);
}
