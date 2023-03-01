package ru.kata.spring.boot_security.demo.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String role_name;

    public Role() {
    }

    public Role(Long id, String role_name) {
        this.id = id;
        this.role_name = role_name;
    }

    public Role(String role_name) {
        this.role_name = role_name;
    }

    @Transient
    @ManyToMany(mappedBy = "roles")
            private Set<User> users;

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public Long getId() {
        return id;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String getAuthority() {
        return role_name;
    }
}
