package com.cognizant.hqlquery.service;

import com.cognizant.hqlquery.model.Employee;
import com.cognizant.hqlquery.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public List<Employee> getAllPermanentEmployees() {
        return employeeRepository.getAllPermanentEmployees();
    }

    @Transactional
    public List<Employee> getAllPermanentEmployeesWithFetch() {
        return employeeRepository.getAllPermanentEmployeesWithFetch();
    }

    @Transactional
    public double getAverageSalary() {
        return employeeRepository.getAverageSalary();
    }

    @Transactional
    public double getAverageSalaryByDepartment(int id) {
        return employeeRepository.getAverageSalaryByDepartment(id);
    }

    @Transactional
    public List<Employee> getAllEmployeesNative() {
        return employeeRepository.getAllEmployeesNative();
    }
}