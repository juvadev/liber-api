package com.liber.api.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Compra")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private int id;

    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Employee employee;

    @Column(name = "fecha_compra")
    private Date purchaseDate;

    @ManyToOne
    @JoinColumn(name = "metodo_pago_id")
    private PaymentMethod paymentMethod;

    @Column(name = "monto_transporte")
    private Double shippingCost;

    @Column(name = "monto_total")
    private Double totalAmount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(Double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
