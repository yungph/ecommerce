package com.ecommerce.ecommerse.Controllers;

import com.ecommerce.ecommerse.Models.Request;
import com.ecommerce.ecommerse.Models.User;
import com.ecommerce.ecommerse.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ecommerce.ecommerse.DTO.LoginRequest;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class UserController {
    @Autowired
    UserService userService;

//    @PostMapping("/register")
//    public ResponseEntity<?> register(@RequestBody User user) {
//        userService.registerUser(user);
//        return ResponseEntity.ok().build();
//    }
//    @PostMapping("/login")
//    public ResponseEntity<User> login(@RequestBody LoginRequest loginRequest) {
//        return ResponseEntity.ok(userService.loginUser(loginRequest));
//    }
//
//    @PostMapping("/CreateUser")
//    public ResponseEntity<?> CreateUser(@RequestBody User user) {
//        userService.CreateUser(user);
//        return ResponseEntity.ok().build();
//    }

    @PutMapping("/UpdateUser")
    public ResponseEntity<?> UpdateUser(@RequestBody User user) {
        userService.UpdateUser(user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/DeleteUser")
    public ResponseEntity<?> DeleteUser(@RequestBody User user) {
        userService.DeleteUser(user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/DeleteUserById")
    public ResponseEntity<?> DeleteUserById(@RequestBody String id) {
        userService.DeleteUserById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/GetUserByEmail")
    public ResponseEntity<?> getUser(@RequestBody Request request) {
        User user = userService.GetUserByEmail(request.getEmail());
        return ResponseEntity.ok(user);
    }

    @GetMapping("/GetAllUsers")
    public ResponseEntity<?> getAllUsers() {
        List<User> users = userService.GetAllUsers();
        return ResponseEntity.ok().body(users);
    }

    @PutMapping("/UpdateAddress")
    public ResponseEntity<?> UpdateAddress(@RequestBody   Request request) {
        userService.UpdateAddress( request.getId(),request.getAddress() );
        return ResponseEntity.ok().build();
    }

    @GetMapping("/GetAddressById")
    public ResponseEntity<?> GetAddressById(@RequestBody Request request) {
        String Address = userService.GetAddressById(request.getId());
        return ResponseEntity.ok(Address);
    }

}
