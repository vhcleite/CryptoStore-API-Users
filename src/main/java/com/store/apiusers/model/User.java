package com.store.apiusers.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    private String id;
    private String name;
    private String raidenAccount;
    private String password;

    public User() {
    }

    public User(String id, String name, String raidenAccount, String password) {
        this.id = id;
        this.name = name;
        this.raidenAccount = raidenAccount;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRaidenAccount() {
        return raidenAccount;
    }

    public void setRaidenAccount(String raidenAccount) {
        this.raidenAccount = raidenAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", raidenAccount=" + raidenAccount +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
