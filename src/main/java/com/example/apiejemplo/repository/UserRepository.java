package com.example.apiejemplo.repository;

import com.example.apiejemplo.entity.Tweet;
import com.example.apiejemplo.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email = :email")
    public Optional<User> searchByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
    public Optional<User> getUserByEmailAndPassword(
            @Param("email") String email,
            @Param("password") String password
    );


}
