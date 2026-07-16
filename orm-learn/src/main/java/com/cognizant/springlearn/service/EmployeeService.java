package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public Employee get(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }

    @Transactional
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }
}