package com.project.todosimple.application.controllers;

import com.project.todosimple.domain.entities.User;
import com.project.todosimple.application.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById (@PathVariable Long id)
    {
        User returnUser = this.userService.findById(id);
        return ResponseEntity.status(200).body(returnUser);
    }

    @PostMapping
    @Validated(User.CreateUser.class)
    public ResponseEntity<Void> create (@Valid @RequestBody User obj)
    {
        this.userService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    @Validated(User.UpdateUser.class)
    public ResponseEntity<Void> update (@Valid @RequestBody User obj, @PathVariable Long id)
    {
        obj.setId(id);
        this.userService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id)
    {
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
