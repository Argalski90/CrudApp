package com.argalski.Dao;

import com.argalski.Entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakeData")
public class DaoImpl implements Dao {

    private static Map<Integer, User> users;

    static {
        users = new HashMap<Integer, User>(){

            {
                put(1, new User(1, "Pawel", "IT"));
                put(2, new User(2, "Maciek", "Maths"));
                put(3, new User(3, "Darek", "Biology"));
            }
        };
    }

    @Override
    public Collection<User> getAllUsers() {
        return this.users.values();
    }

    @Override
    public User getUserById(int id) {
        return this.users.get(id);
    }

    @Override
    public void removeUserById(int id) {
        this.users.remove(id);
    }

    @Override
    public void updateUser(User user) {

        User u = users.get(user.getId());
        u.setCourse(user.getCourse());
        u.setName(user.getName());
        users.put(user.getId(), user);
    }

    @Override
    public void insertUserToDb(User user) {
        this.users.put(user.getId(), user);
    }
}

