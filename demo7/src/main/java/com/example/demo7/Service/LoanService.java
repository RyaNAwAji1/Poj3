package com.example.demo7.Service;

import com.example.demo7.Exception.BookNotFoundException;
import com.example.demo7.Model.Books;
import com.example.demo7.Model.Loan;
import com.example.demo7.Repository.BooksRepository;
import com.example.demo7.Repository.LoanRepository;
import com.example.demo7.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
    private final BooksRepository booksRepository;
    private final UserRepository userRepository;
    private final BooksService booksService;

    public void addLoan(Loan loan) {
        loanRepository.save(loan);
    }

    public List<Loan> getLoans() {
        return loanRepository.findAll();
    }

    public void lendBookId(Integer userId , Integer bookId) {
        Books book = booksService.bookId(bookId);
        Set<Books> booksSet=new HashSet<>();
        booksSet.add(book);
        Loan loan = new Loan(null, bookId, userId, booksSet);
        loanRepository.save(loan);
    }
    public String getLoanBookId(Integer bookId) {
        Books book = booksRepository.findById(bookId)
                .orElseThrow(()->new  BookNotFoundException("Book Id Not Found !"));
        Loan loan = loanRepository.findById(bookId);
        Set<Books> booksSet= loan.getBooks();
        booksSet.remove(book);
        List<Loan> loanSet = getLoans();
        loanSet.remove(loan);
        booksRepository.save(book);
        loanRepository.save(loan);
        return "The Book Return ";
    }
}
