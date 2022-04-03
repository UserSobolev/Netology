public class User {
    private String login;
    private  String password;
    private String email;
    private int age;

    public User(String login, String email, String password, int age) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}
