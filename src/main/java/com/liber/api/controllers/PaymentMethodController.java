package com.liber.api.controllers;

import com.liber.api.models.PaymentMethod;
import com.liber.api.repositories.IPaymentMethodRepository;
import com.liber.api.services.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/payment_methods")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodService paymentMethodService;

    @GetMapping
    public ArrayList<PaymentMethod> getPaymentMethods () {
        return this.paymentMethodService.getPaymentMethods();
    }

    @GetMapping("/{id}")
    public Optional<PaymentMethod> getPaymentMethodById(@PathVariable int id) {
        return this.paymentMethodService.getPaymentMethodById(id);
    }

    @PostMapping("/save")
    public PaymentMethod savePaymentMethod (@RequestBody PaymentMethod paymentMethod) {
        return  this.paymentMethodService.savePaymentMethod(paymentMethod);
    }

    @PutMapping("/update/{id}")
    public PaymentMethod updatePaymentMethod (@PathVariable int id, @RequestBody PaymentMethod request) {
        return this.paymentMethodService.updatePaymentMethodById(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deletePaymentMethodById (@PathVariable int id) {
        return this.paymentMethodService.deletePaymentMethodById(id);
    }
}
