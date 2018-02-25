package com.argalski.controller;

import com.argalski.entity.User;
import com.argalski.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(UserController.REQUEST_MAPPING)
public class UserController {

    static final String REQUEST_MAPPING = "/users";

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<User> list() {
        return this.userService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody User user) {
        this.userService.create(user);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public User read(@PathVariable("id") long id) {
        return this.userService.find(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody User user) {
        this.userService.update(user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") int id) {
        this.userService.delete(id);
    }
}

