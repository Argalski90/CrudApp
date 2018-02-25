package com.argalski.dao;

import com.argalski.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    private static Map<Long, User> users;

    static {
        users = new HashMap<Long, User>() {
            {
                put(1L, new User(1L, "Pawel", "IT"));
                put(2L, new User(2L, "Maciek", "Maths"));
                put(3L, new User(3L, "Darek", "Biology"));
            }
        };
    }

    @Override
    public Collection<User> getAll() {
        return users.values();
    }

    @Override
    public void create(User user) {
        if (Objects.nonNull(user)) {
            users.put(user.getId(), user);
        }
    }

    @Override
    public User find(long id) {
        if (users.containsKey(id)) {
            return users.get(id);
        }
        return null;
    }

    @Override
    public void update(User user) {
        if (Objects.nonNull(user) && users.containsKey(user.getId())) {
            User updatedUser = users.get(user.getId());
            updatedUser.setCourse(user.getCourse());
            updatedUser.setName(user.getName());
            users.put(user.getId(), updatedUser);
        }
    }

    @Override
    public void delete(long id) {
        if (users.containsKey(id)) {
            users.remove(id);
        }
    }
}

