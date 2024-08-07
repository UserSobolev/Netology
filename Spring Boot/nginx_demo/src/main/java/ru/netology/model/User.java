package ru.netology.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class User {
    @Size(min = 4, max = 20)
    private final String password;

    @Size(min = 2, max = 20)
    @NotBlank
    private final String user;

    public User(String user, String password) {
        this.password = password;
        this.user = user;
    }

    @Override
    public String toString() {
        return "User{" +
                "password='" + password + '\'' +
                ", name='" + user + '\'' +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User person = (User) o;
        return Objects.equals(password, person.password) && Objects.equals(user, person.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password, user);
    }
}
