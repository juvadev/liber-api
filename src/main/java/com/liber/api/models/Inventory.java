package com.liber.api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Inventario")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inventario")
    private int id;

    @ManyToOne
    @JoinColumn(name = "establecimiento_id")
    private Establishment establishment;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "seccion_id")
    private Section section;

    @Column
    private int stock;

    @Column(name = "stock_minimo")
    private  int minStock;

    @Column(name = "referencia_ubicacion")
    private String locationRef;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Establishment getEstablishment() {
        return establishment;
    }

    public void setEstablishment(Establishment establishment) {
        this.establishment = establishment;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getMinStock() {
        return minStock;
    }

    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }

    public String getLocationRef() {
        return locationRef;
    }

    public void setLocationRef(String locationRef) {
        this.locationRef = locationRef;
    }
}
