package com.cognizant.hqlquery;

import com.cognizant.hqlquery.model.Employee;
import com.cognizant.hqlquery.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class HqlNativeQueryApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(HqlNativeQueryApplication.class);

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(HqlNativeQueryApplication.class, args);
    }

    @Override
    public void run(String... args) {
        testGetAllPermanentEmployees();
        testGetAllPermanentEmployeesWithFetch();
        testAverageSalary();
        testAverageSalaryByDepartment();
        testNativeQuery();
    }

    private void testGetAllPermanentEmployees() {
        LOGGER.info("testGetAllPermanentEmployees start");
        List<Employee> employees = employeeService.getAllPermanentEmployees();
        for (Employee employee : employees) {
            LOGGER.info("Employee: {}", employee);
            LOGGER.info("Department: {}", employee.getDepartment());
            LOGGER.info("Skills: {}", employee.getSkillList());
        }
        LOGGER.info("testGetAllPermanentEmployees end");
    }

    private void testGetAllPermanentEmployeesWithFetch() {
        LOGGER.info("testGetAllPermanentEmployeesWithFetch start");
        List<Employee> employees = employeeService.getAllPermanentEmployeesWithFetch();
        for (Employee employee : employees) {
            LOGGER.info("Employee: {}", employee);
            LOGGER.info("Department: {}", employee.getDepartment());
            LOGGER.info("Skills: {}", employee.getSkillList());
        }
        LOGGER.info("testGetAllPermanentEmployeesWithFetch end");
    }

    private void testAverageSalary() {
        LOGGER.info("testAverageSalary start");
        double averageSalary = employeeService.getAverageSalary();
        LOGGER.info("Average salary: {}", averageSalary);
        LOGGER.info("testAverageSalary end");
    }

    private void testAverageSalaryByDepartment() {
        LOGGER.info("testAverageSalaryByDepartment start");
        double averageSalary = employeeService.getAverageSalaryByDepartment(1);
        LOGGER.info("Average salary for department 1: {}", averageSalary);
        LOGGER.info("testAverageSalaryByDepartment end");
    }

    private void testNativeQuery() {
        LOGGER.info("testNativeQuery start");
        List<Employee> employees = employeeService.getAllEmployeesNative();
        for (Employee employee : employees) {
            LOGGER.info("Employee: {}", employee);
        }
        LOGGER.info("testNativeQuery end");
    }
}