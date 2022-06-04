package com.example.demo7.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @NotNull(message = "Most To Write Id User ID")
    private Integer id;
    @NotEmpty(message = "Most To Write User Name")
    private String userName;
    @NotEmpty(message = "Most To Write PassWord")
    private String passWord;
}
