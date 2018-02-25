package com.argalski.Dao;

import com.argalski.Entity.User;

import java.util.Collection;

public interface Dao {
    Collection<User> getAllUsers();

    User getUserById(int id);

    void removeUserById(int id);

    void updateUser(User user);

    void insertUserToDb(User user);
}
