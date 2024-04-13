package com.example.apiejemplo.controller;

import com.example.apiejemplo.entity.User;
import com.example.apiejemplo.repository.TweetRepository;
import com.example.apiejemplo.repository.UserRepository;
import com.example.apiejemplo.util.GenericMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(maxAge = 3600)
public class TweetController {

    @Autowired
    TweetRepository tweetRepository;

    @GetMapping("user/tweets/{id}")
    public ResponseEntity<?> list(@PathVariable("id") long id) {
        var tweets = tweetRepository.findTweetsByUser(id);
        return ResponseEntity.status(200).body(tweets);
    }

}
