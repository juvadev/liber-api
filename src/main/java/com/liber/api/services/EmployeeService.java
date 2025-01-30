package com.liber.api.services;

import com.liber.api.models.Employee;
import com.liber.api.repositories.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    public ArrayList<Employee> getEmployees () {
        return (ArrayList<Employee>) employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById (int id) {
        return employeeRepository.findById(id);
    }

    public Employee saveEmployee (Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployeeById (int id, Employee request) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setName(request.getName());
            employee.setLastname(request.getLastname());
            employee.setDni(request.getDni());
            employee.setPhone(request.getPhone());
            employee.setState(request.getState());

            return employeeRepository.save(employee);
        } else {
            throw new RuntimeException("Employee not found with id " + id);
        }
    }

    public Boolean deleteEmployeeById (int id) {
        try {
            employeeRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
