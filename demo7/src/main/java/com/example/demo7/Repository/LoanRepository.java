package com.example.demo7.Repository;

import com.example.demo7.Model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository <Loan,Integer> {
}
