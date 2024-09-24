package com.ecommerce.ecommerse.Repo;

import com.ecommerce.ecommerse.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

    Optional<User> findByUsername(String username);
    User findByEmail(String email);

    @Query(value = "select * from user_details  WHERE email = :email", nativeQuery = true)
    User GetUserByEmail(@Param("email") String email);

    @Modifying
    @Query(value = "UPDATE user_details SET address = :address WHERE id = :id", nativeQuery = true)
    void updateAddress(@Param("id") String id, @Param("address") String address);


}
