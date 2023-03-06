package ru.kata.spring.boot_security.demo.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;



@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @ManyToMany(mappedBy = "roles")
    private List<User> userList;

    @Id
    private int roleId;
    private String roleNaming;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleNaming() {
        return roleNaming;
    }

    public void setRoleNaming(String roleNaming) {
        this.roleNaming = roleNaming;
    }

    @Override
    public String getAuthority() {
        return null;
    }
}
