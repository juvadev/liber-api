package com.liber.api.repositories;

import com.liber.api.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

}

