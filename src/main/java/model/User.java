package model;

import java.util.Objects;

public class User {
    private Long id;

    private String name;

    private String pass;

    private Long age;

    public User(Long id, String name, String pass, Long age) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.age = age;
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    public User(long id) {
        this.id = id;
    }

    public User() {

    }

    public User(String name, String pass, Long age) {
        this.name = name;
        this.pass = pass;
        this.age = age;
    }


    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) &&
                name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public boolean validate() {
        return name != null && !name.isEmpty() && id > 0 && pass != null && !pass.isEmpty() && age > 0;
    }
}
