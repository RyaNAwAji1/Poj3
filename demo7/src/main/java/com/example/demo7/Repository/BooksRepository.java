package com.example.demo7.Repository;

import com.example.demo7.Model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository <Books,Integer> {
}
