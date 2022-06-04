package com.example.demo7.Controller;

import com.example.demo7.DTO.Api;
import com.example.demo7.Model.Books;
import com.example.demo7.Service.BooksService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/books")
@AllArgsConstructor
public class BooksController {

    private final BooksService booksService;
    Logger log= LoggerFactory.getLogger(BooksController.class);

    @GetMapping("GetBooks")
    public ResponseEntity <List<Books>> getBooks(){
        return ResponseEntity.status(HttpStatus.OK).body(booksService.getBooks());
    }
    @PostMapping("AddBook")
    public ResponseEntity <Api> addBook(@RequestBody @Valid Books books){
        booksService.addBooks(books);
        return ResponseEntity.status(HttpStatus.OK).body(
                new Api("New User added !",200));
    }


}
