package com.example.demo7.Service;

import com.example.demo7.Exception.InvalidException;
import com.example.demo7.Model.User;
import com.example.demo7.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }
    public User userId(Integer userId){
        User user = userRepository.findById(userId).
                orElseThrow(()-> new InvalidException("Invalid User Id !"));;
        return user;
    }

}
