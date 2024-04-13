package com.example.apiejemplo.repository;

import com.example.apiejemplo.entity.Tweet;
import com.example.apiejemplo.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TweetRepository extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.id = :id")
    List<Tweet> findTweetsByUser(@Param("id") long id);


}
