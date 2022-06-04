package com.example.demo7.Controller;

import com.example.demo7.DTO.Api;
import com.example.demo7.Model.Loan;
import com.example.demo7.Service.LoanService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/loan")
@AllArgsConstructor
public class LoanController {

    private final LoanService loanService;
    Logger log= LoggerFactory.getLogger(LoanController.class);


    @GetMapping("/getLoan")
    public ResponseEntity <List<Loan>> getLoans(){
        log.info("get request incoming");
        return ResponseEntity.status(HttpStatus.OK).body(loanService.getLoans());
    }
    @PostMapping("/updateLoan")
    public ResponseEntity <Api> addUser(@RequestBody @Valid Loan loan){
        loanService.addLoan(loan);
        return ResponseEntity.status(HttpStatus.OK).body(
                new Api("New User added !",200));

    }
    @PutMapping("/update/{userId}/{bookId}")
    public ResponseEntity lendBook(@PathVariable Integer userId, @PathVariable Integer bookId ){
        loanService.lendBookId(userId,bookId);
        log.info("lendBook it's used");
        return ResponseEntity.status(HttpStatus.OK).body(
                new Api("New Loan added !",200));
    }
    @GetMapping ("/get/{bookId}")
    public ResponseEntity getLoanBookId(@PathVariable Integer bookId ){
        loanService.getLoanBookId(bookId);
        log.info("lendBook it's return ");
        return ResponseEntity.status(200).body(
                new Api("bad request bookID is invalid!",200));
    }



}
