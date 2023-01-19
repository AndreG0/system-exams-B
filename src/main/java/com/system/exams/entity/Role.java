package com.system.exams.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    private int roleId;
    private String rolName;

    //un rol le puede pertenecer a muhcos usuarios
    //cuando hago una operación a un registro de esta tabla, le afecta a todos sus hijos
    //fetch lazy: busqueda de tipo perezosa, tengo que indicarle la propiedad que debe llamar
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
    private Set<UserRole> userRoles = new HashSet<>();

    public Role() {
    }

    public Role(int roleId, String rolName) {
        this.roleId = roleId;
        this.rolName = rolName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRolName() {
        return rolName;
    }

    public void setRolName(String rolName) {
        this.rolName = rolName;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
