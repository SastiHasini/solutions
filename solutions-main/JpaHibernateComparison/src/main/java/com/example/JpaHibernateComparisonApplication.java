package com.example;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

@SpringBootApplication
public class JpaHibernateComparisonApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(JpaHibernateComparisonApplication.class, args);
    }

    @Override
    public void run(String... args) {
        employeeService.addEmployee(new Employee(null, "John", 60000.0, "IT"));
        employeeService.addEmployee(new Employee(null, "Jane", 70000.0, "HR"));
        List<Employee> employees = employeeService.getAllEmployees();
        System.out.println(employees);
    }
}