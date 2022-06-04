package com.example.demo7.Service;

import com.example.demo7.Exception.InvalidException;
import com.example.demo7.Model.Books;
import com.example.demo7.Model.Loan;
import com.example.demo7.Repository.BooksRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
@AllArgsConstructor
public class BooksService {

    private final BooksRepository booksRepository;


    public void addBooks(Books books) {
        booksRepository.save(books);
    }

    public List<Books> getBooks() {
        return booksRepository.findAll();
    }

    public Books bookId(Integer bookId ){
        Books book = booksRepository.findById(bookId)
                .orElseThrow(()-> new InvalidException("Invalid Book Id !"));
        return book;

    }
}
