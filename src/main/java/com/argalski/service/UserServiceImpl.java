package com.argalski.service;

import com.argalski.entity.User;
import com.argalski.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public Collection<User> getAll() {
        return this.userDao.getAll();
    }

    @Override
    public void create(User user) {
        this.userDao.create(user);
    }

    @Override
    public User find(long id) {
        return this.userDao.find(id);
    }

    @Override
    public void update(User user) {
        this.userDao.update(user);
    }

    @Override
    public void delete(long id) {
        this.userDao.delete(id);
    }
}
