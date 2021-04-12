package ru.ivanlis.wheretohavelunch.model;

import java.util.Date;

public class User extends AbstractBaseEntity {
    private String name;

    private String email;

    private String password;

    private Date registered = new Date();

    public User() {
    }

    public User(User u) {
        this(u.getId(), u.getName(), u.getEmail(), u.getPassword(), u.getRegistered());
    }

    public User(Integer id, String name, String email, String password) {
        this(id, name, email, password, new Date());
    }

    public User(Integer id, String name, String email, String password, Date registered) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.registered = registered;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", registered=" + registered +
                '}';
    }
}
