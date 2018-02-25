package com.argalski.dao;

import com.argalski.entity.User;

import java.util.Collection;

public interface UserDao {

    Collection<User> getAll();

    void create(User user);

    User find(long id);

    void update(User user);

    void delete(long id);

}
