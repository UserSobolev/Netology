import java.util.Optional;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
    }

    Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.surname = personBuilder.surname;
        this.age = personBuilder.age;
        this.address = personBuilder.address;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setAddress(this.address) // можно убрать адрес при необходимости,
                .setSurname(this.surname);
    }

    public boolean hasAge() {
        return Optional.ofNullable(age).isPresent();
    }
    public boolean hasAddress() {
        if (address == null) {
            return false;
        } else {
            return true;
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        if (Optional.ofNullable(age).isEmpty()) {
            System.out.print("Возраст неизвестен: - ");
            return 0;
        } else {
            return age.getAsInt();
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String city) {
        this.address = city;
    }

    public void happyBirthday() {
        //Если возрат неизвестен, то предположен, что он будет 0
        if (Optional.ofNullable(age).isEmpty()) {
            System.out.println("С Днем Рождения!");
            this.age = OptionalInt.of(1);
        } else {
            System.out.println("С Днем Рождения!");
            this.age = OptionalInt.of(age.getAsInt() + 1);
        }
    }

    @Override
    public String toString() {
        return
                "\n Имя: " + name +
                "\n Фамлия: " + surname +
                "\n Возраст: " + (Optional.ofNullable(age).isEmpty() ? "возраст неизвечтен" : age.getAsInt()) +
                "\n Адрес: " + (address == null ? "адрес отсутствует" : address);
    }
}
