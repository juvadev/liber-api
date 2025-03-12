package com.liber.api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Rol_Permiso")
public class RolePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol_permiso")
    private int id;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "permiso_id")
    private Permission permission;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
