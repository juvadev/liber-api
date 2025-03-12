package com.liber.api.services;

import com.liber.api.models.PaymentMethod;
import com.liber.api.repositories.IPaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PaymentMethodService {
    @Autowired
    private IPaymentMethodRepository paymentMethodRepository;

    public ArrayList<PaymentMethod> getPaymentMethods () {
        return (ArrayList<PaymentMethod>) paymentMethodRepository.findAll();
    }

    public Optional<PaymentMethod> getPaymentMethodById(int id) {
        return paymentMethodRepository.findById(id);
    }

    public PaymentMethod savePaymentMethod (PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }

    public PaymentMethod updatePaymentMethodById (int id, PaymentMethod request) {
        Optional<PaymentMethod> optionalPaymentMethod = paymentMethodRepository.findById(id);

        if (optionalPaymentMethod.isPresent()) {
            PaymentMethod paymentMethod = optionalPaymentMethod.get();
            paymentMethod.setName(request.getName());
            return paymentMethodRepository.save(paymentMethod);
        } else {
            throw new RuntimeException("Payment Method not found with id " + id);
        }
    }

    public Boolean deletePaymentMethodById (int id) {
        try {
            paymentMethodRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
