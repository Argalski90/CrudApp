package com.argalski.Dao;

import com.argalski.Entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
@Qualifier("mySqlData")
public class MySqlUserImpl implements Dao {


    @Override
    public Collection<User> getAllUsers() {
        return new ArrayList<User>(){
            {
                add(new User(1, "Mariusz", "PE"));
            }
        };
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public void removeUserById(int id) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void insertUserToDb(User user) {

    }
}
