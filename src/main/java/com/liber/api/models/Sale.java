package com.liber.api.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Venta")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private int id;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Employee employee;

    @Column(name = "fecha_venta")
    private Date saleDate;

    @ManyToOne
    @JoinColumn(name = "metodo_pago_id")
    private PaymentMethod paymentMethod;

    @Column(name = "monto_total")
    private double totalAmount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
