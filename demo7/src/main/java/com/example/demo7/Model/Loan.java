package com.example.demo7.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Loan {
    @Id
    @NotNull(message = "Most To Write Id Number")
    private Integer id;
    @NotNull(message = "Most To Write Id User ID")
    private Integer userId;
    @NotNull(message = "Most To Write Id Book ID")
    private Integer bookId;


    @ManyToMany
    private Set <Books> books;
}
