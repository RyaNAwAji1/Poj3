package com.example.demo7.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull(message = "Most To Write Id Number")
    private Integer id;
    @NotEmpty(message = "Most To Write Name")
    private String name;
    @NotEmpty(message = "Most To Write Genre")
    private String genre;


    @ManyToMany(mappedBy = "bookId", cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "bookId")
    private Set <Loan> loans;
}