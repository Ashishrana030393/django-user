package com.gongo.djangouser.resource;

import com.gongo.djangouser.entity.User;
import com.gongo.djangouser.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserResource {
    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    Optional<User> findUserById(@RequestParam("id") long id){
        return this.userService.findUserById(id);
    }

    @PostMapping
    User save(@RequestBody User user){
        return this.userService.createUser(user);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(@RequestBody User user){
         this.userService.updateUser(user);
    }
}
