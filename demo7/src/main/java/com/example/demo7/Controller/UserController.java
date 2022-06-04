package com.example.demo7.Controller;

import com.example.demo7.DTO.Api;
import com.example.demo7.Model.User;
import com.example.demo7.Service.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    Logger log= LoggerFactory.getLogger(UserController.class);


    @GetMapping("/getUsers")
    public ResponseEntity <List<User>> getUsers(){
        log.info("get request incoming");
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
    }
    @PostMapping("/update")
    public ResponseEntity <Api> addUser(@RequestBody @Valid User user){
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new Api("New User added !",201));

    }




}
