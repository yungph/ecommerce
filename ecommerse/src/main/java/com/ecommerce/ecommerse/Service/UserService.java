package com.ecommerce.ecommerse.Service;

import com.ecommerce.ecommerse.DTO.LoginRequest;
import com.ecommerce.ecommerse.Models.User;
import com.ecommerce.ecommerse.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

//    private String hashPassword(String password) {
//        // Implement password hashing (e.g., using BCrypt)
//        return new BCryptPasswordEncoder().encode(password);
//    }

//    public void registerUser(User user) {
//        user.setId(UUID.randomUUID().toString().replace("-", ""));
//        user.setPassword(hashPassword(user.getPassword()));
//        userRepo.save(user);
//    }
//
//    public User loginUser(LoginRequest loginRequest) {
//        User user = userRepo.findByUsername(loginRequest.getUsername())
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        if (!new BCryptPasswordEncoder().matches(loginRequest.getPassword(), user.getPassword())) {
//            throw new RuntimeException("Invalid credentials");
//        }
//
//        return user; // Return user or a token depending on your implementation
//    }
//
//    public void CreateUser(User user) {
//        String id = UUID.randomUUID().toString().replace("-", "");
//        user.setId(id);
//        userRepo.save(user);
//    }

    public void UpdateUser(User user) {
        userRepo.save(user);
    }

    public void DeleteUser(User user) {
        userRepo.delete(user);
    }
    public void DeleteUserById(String id) {
        userRepo.deleteById(id);
    }

    public User GetUserByEmail(String email) {
        return userRepo.GetUserByEmail(email);
    }
    public User GetUserById(String id) {
        return userRepo.findById(id).get();
    }

    public List<User> GetAllUsers() {
        return userRepo.findAll();
    }

    @Transactional
    public void UpdateAddress(String id, String address) {
        userRepo.updateAddress(id, address);
    }
    public String GetAddressById(String id) {
        return GetUserById(id).getAddress();
    }









}
