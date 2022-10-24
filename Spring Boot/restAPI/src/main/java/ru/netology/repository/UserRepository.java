package ru.netology.repository;

import org.springframework.stereotype.Repository;
import ru.netology.enums.Authorities;
import ru.netology.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

    private final ConcurrentHashMap<User, List<Authorities>> authorities;

    public UserRepository() {
        authorities = new ConcurrentHashMap<>();
        this.authorities.put(new User("Anton", "1234"),
                new ArrayList<>(Collections.singleton(Authorities.READ)));
    }

    public List<Authorities> getUserAuthorities(User user) {
        if (authorities.get(user) == null) {
            return new ArrayList<>();
        }
        return authorities.get(user);
    }
}
