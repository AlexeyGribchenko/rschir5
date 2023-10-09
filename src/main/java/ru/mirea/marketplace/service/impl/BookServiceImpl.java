package ru.mirea.marketplace.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mirea.marketplace.DTO.Book;
import ru.mirea.marketplace.repository.BookRepository;
import ru.mirea.marketplace.service.BookService;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book getOne(Integer id) {
        return this.bookRepository.findById(id).orElse(null);
    }

    public List<Book> getAll() {
        return this.bookRepository.findAll();
    }

    public void create(Book book) {
        this.bookRepository.saveAndFlush(book);
    }

    public boolean update(Integer id, Book book) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book oldBook = optionalBook.get();
            oldBook.setAuthor(book.getAuthor());
            oldBook.setPrice(book.getPrice());
            oldBook.setTitle(book.getTitle());
            oldBook.setSellerId(book.getSellerId());
            oldBook.setProductType(book.getProductType());
            bookRepository.saveAndFlush(oldBook);
            return true;
        }
        return false;
    }

    public void delete(Integer id) {
        this.bookRepository.deleteById(id);
    }
}
