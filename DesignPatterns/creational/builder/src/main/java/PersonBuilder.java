import java.util.OptionalInt;

public class PersonBuilder{
    protected String name;
    protected String surname;
    protected OptionalInt age;
    protected String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname =surname;
        return this;
    }

    public PersonBuilder setAge(int  age) {
        if (age >= 0) {
            this.age = OptionalInt.of(age);
            return this;
        } else {
            throw new IllegalArgumentException("Возраст не может быть отрицательным.");
        }
    }

    public PersonBuilder setAddress(String city) {
        this.address = city;
        return this;
    }

    public Person build() {
        if (this.name == null || this.surname == null) {
            throw new IllegalStateException("Для создания пользователя недостаточно данных.");
        } else {
            return new Person(this);
        }
    }
}