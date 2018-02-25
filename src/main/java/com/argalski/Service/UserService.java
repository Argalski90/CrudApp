package com.argalski.Service;

import com.argalski.Dao.DaoImpl;
import com.argalski.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    @Autowired
    @Qualifier("fakeData")
    private DaoImpl userDaoImpl;

    public Collection<User> getAllUsers() {
        return this.userDaoImpl.getAllUsers();
    }

    public User getUserById(int id) {
        return this.userDaoImpl.getUserById(id);
    }

    public void removeUserById(int id) {
        this.userDaoImpl.removeUserById(id);
    }

    public void updateUser(User user) {

       this.userDaoImpl.updateUser(user);
    }

    public void insertUser(User user) {
        this.userDaoImpl.insertUserToDb(user);
    }
}
