package com.liber.api.controllers;

import com.liber.api.models.Employee;
import com.liber.api.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ArrayList<Employee> getEmployees () {
        return employeeService.getEmployees();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById (@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/save")
    public Employee saveEmployee (@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployeeById (@PathVariable int id, @RequestBody Employee request) {
        return employeeService.updateEmployeeById(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteEmployeeById (@PathVariable int id) {
        return employeeService.deleteEmployeeById(id);
    }
}
