package com.system.exams.entity;

import javax.persistence.*;

@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userRoleId;


    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
        //relación de uno a muchos (muchos roles le van a pertenecer a un usuario)
    @ManyToOne
    private Role role;

    public UserRole() {
    }

    public UserRole(int userRoleId, User user, Role role) {
        this.userRoleId = userRoleId;
        this.user = user;
        this.role = role;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
