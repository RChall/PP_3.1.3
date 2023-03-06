package ru.kata.spring.boot_security.demo.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Table(name = "users")
@Entity
public class User implements UserDetails {
    @ManyToMany
    @JoinTable(
            name = "User_Role",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String username;
        private String password;
        private String name;
        private String lastName;
        private String country;
        private int age;

        public User() {   }

        @Override
        public String toString() {
            return id + ") " + name + " " + lastName + ", " + country + ", " + age;
        }

        public User(String name, String lastName, String country, int age) {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
            this.country = country;

        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    /* ██████╗░███████╗████████╗░█████╗░██╗██╗░░░░░░██████╗
       ██╔══██╗██╔════╝╚══██╔══╝██╔══██╗██║██║░░░░░██╔════╝
       ██║░░██║█████╗░░░░░██║░░░███████║██║██║░░░░░╚█████╗░
       ██║░░██║██╔══╝░░░░░██║░░░██╔══██║██║██║░░░░░░╚═══██╗
       ██████╔╝███████╗░░░██║░░░██║░░██║██║███████╗██████╔╝
       ╚═════╝░╚══════╝░░░╚═╝░░░╚═╝░░╚═╝╚═╝╚══════╝╚═════╝░*/
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    //не просрочен
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
//не заблокирован
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
//пароль не просрочен
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    //работающий ли аккаунт
    @Override
    public boolean isEnabled() {
        return true;
    }
}

