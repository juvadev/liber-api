package com.liber.api.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Movimiento_Inventario")
public class StockTransfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento_inventario")
    private int id;

    @ManyToOne
    @JoinColumn(name = "establecimiento_origen_id")
    private Establishment establishmentOrigin;

    @ManyToOne
    @JoinColumn(name = "establecimiento_destino_id")
    private Establishment establishmentDestination;

    @Column(name = "fecha_movimiento")
    private Date transferDate;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Product product;

    @Column(name = "cantidad")
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Establishment getEstablishmentOrigin() {
        return establishmentOrigin;
    }

    public void setEstablishmentOrigin(Establishment establishmentOrigin) {
        this.establishmentOrigin = establishmentOrigin;
    }

    public Establishment getEstablishmentDestination() {
        return establishmentDestination;
    }

    public void setEstablishmentDestination(Establishment establishmentDestination) {
        this.establishmentDestination = establishmentDestination;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
