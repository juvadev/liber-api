package com.liber.api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Detalle_Venta")
public class SaleDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_venta")
    private int id;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Product product;

    @Column(name = "cantidad")
    private int quantity;

    @Column(name = "precio_unidad")
    private double unitPrice;

    @Column(name = "descuento")
    private double discount;

    @Column(name = "sub_total")
    private double subtotal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
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

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
