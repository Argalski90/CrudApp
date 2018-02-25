package com.argalski.service;

import com.argalski.entity.User;

import java.util.Collection;

public interface UserService {

    Collection<User> getAll();

    void create(User user);

    User find(long id);

    void update(User user);

    void delete(long id);

}
