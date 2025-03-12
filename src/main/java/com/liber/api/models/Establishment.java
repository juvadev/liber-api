package com.liber.api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Establecimiento")
public class Establishment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_establecimiento")
    private int id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "direccion")
    private String address;

    @Column(name = "ciudad")
    private String city;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private State state;

    @ManyToOne
    @JoinColumn(name = "tipo_establecimiento_id")
    private EstablishmentType establishmentType;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public EstablishmentType getEstablishmentType() {
        return establishmentType;
    }

    public void setEstablishmentType(EstablishmentType establishmentType) {
        this.establishmentType = establishmentType;
    }
}
