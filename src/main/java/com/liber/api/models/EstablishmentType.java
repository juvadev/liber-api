package com.liber.api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "TipoEstablecimiento")
public class EstablishmentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_establecimiento")
    private int id;

    @Column(name = "nombre")
    private String name;

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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
