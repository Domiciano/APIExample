package com.example.apiejemplo.controller;

import com.example.apiejemplo.entity.User;
import com.example.apiejemplo.repository.UserRepository;
import com.example.apiejemplo.util.GenericMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(maxAge = 3600)
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("user/create")
    public ResponseEntity<?> create(@RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.status(200).body(new GenericMessage("Usuario almacenado exitosamente"));
    }


    @GetMapping("user/list")
    public ResponseEntity<?> list() {
        var users = userRepository.findAll();
        return ResponseEntity.status(200).body(users);
    }

    @GetMapping("user/search/{id}") //user/search/10
    public ResponseEntity<?> findById(@PathVariable("id") long id){
        var user = userRepository.findById(id);
        if(user.isPresent()){
            return ResponseEntity.status(200).body(user.get());
        }else{
            return ResponseEntity.status(400).body(
                    new GenericMessage("Usuario no encontrado")
            );
        }
    }

    @GetMapping("user/searchByEmail/{email}") //user/searchByEmail/alfa@a.com
    public ResponseEntity<?> searchByEmail(@PathVariable("email") String email){

        var user = userRepository.searchByEmail(email);
        if(user.isPresent()){
            return ResponseEntity.status(200).body(user.get());
        }else{
            return ResponseEntity.status(400).body(new GenericMessage("Usuario no encontrado"));
        }

    }

    @DeleteMapping("user/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
       userRepository.deleteById(id);
       return ResponseEntity.status(200).body(
               new GenericMessage("Usuario Eliminado")
       );
    }


}
