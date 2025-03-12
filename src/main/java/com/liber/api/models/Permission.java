package com.liber.api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Permiso")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permiso")
    private int id;

    @Column(name = "nombre_permiso")
    private String name;

    @Column(name = "descripcion")
    private String description;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private State state;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
