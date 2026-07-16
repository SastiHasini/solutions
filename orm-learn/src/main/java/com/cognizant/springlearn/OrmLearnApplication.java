package com.cognizant.springlearn;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.model.Department;
import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.model.Stock;
import com.cognizant.springlearn.model.Skill;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.DepartmentService;
import com.cognizant.springlearn.service.EmployeeService;
import com.cognizant.springlearn.service.StockService;
import com.cognizant.springlearn.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    @Autowired
    private CountryService countryService;

    @Autowired
    private StockService stockService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private SkillService skillService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) {
        LOGGER.info("Country service started");
        testFindCountryContaining();
        testFindCountryContainingSorted();
        testFindCountryStartingWith();
        testFacebookSeptemberStocks();
        testGoogleGreaterThan1250();
        testTop3HighestVolume();
        testLowestNetflixStocks();
        testGetEmployee();
        testAddEmployee();
        testUpdateEmployee();
        testGetDepartment();
        testAddSkillToEmployee();
    }

    private void testFindCountryContaining() {
        LOGGER.info("testFindCountryContaining start");
        List<Country> countries = countryService.findCountriesContaining("ou");
        LOGGER.debug("Countries containing 'ou': {}", countries);
        LOGGER.info("testFindCountryContaining end");
    }

    private void testFindCountryContainingSorted() {
        LOGGER.info("testFindCountryContainingSorted start");
        List<Country> countries = countryService.findCountriesContainingSorted("ou");
        LOGGER.debug("Countries containing 'ou' sorted: {}", countries);
        LOGGER.info("testFindCountryContainingSorted end");
    }

    private void testFindCountryStartingWith() {
        LOGGER.info("testFindCountryStartingWith start");
        List<Country> countries = countryService.findCountriesStartingWith("U");
        LOGGER.debug("Countries starting with 'U': {}", countries);
        LOGGER.info("testFindCountryStartingWith end");
    }

    private void testFacebookSeptemberStocks() {
        LOGGER.info("testFacebookSeptemberStocks start");
        List<Stock> stocks = stockService.findByCodeAndDateBetween("FB",
                LocalDate.of(2020, 9, 1),
                LocalDate.of(2020, 9, 30));
        LOGGER.debug("Facebook September stocks: {}", stocks);
        LOGGER.info("testFacebookSeptemberStocks end");
    }

    private void testGoogleGreaterThan1250() {
        LOGGER.info("testGoogleGreaterThan1250 start");
        List<Stock> stocks = stockService.findByCodeAndCloseGreaterThan("GOOGL", 1250.0);
        LOGGER.debug("Google stocks with close greater than 1250: {}", stocks);
        LOGGER.info("testGoogleGreaterThan1250 end");
    }

    private void testTop3HighestVolume() {
        LOGGER.info("testTop3HighestVolume start");
        List<Stock> stocks = stockService.findTop3ByOrderByVolumeDesc();
        LOGGER.debug("Top 3 stocks by volume: {}", stocks);
        LOGGER.info("testTop3HighestVolume end");
    }

    private void testLowestNetflixStocks() {
        LOGGER.info("testLowestNetflixStocks start");
        List<Stock> stocks = stockService.findTop3ByCodeOrderByCloseAsc("NFLX");
        LOGGER.debug("Lowest Netflix stocks: {}", stocks);
        LOGGER.info("testLowestNetflixStocks end");
    }

    private void testGetEmployee() {
        LOGGER.info("testGetEmployee start");
        Employee employee = employeeService.get(1);
        LOGGER.debug("Employee: {}", employee);
        if (employee != null) {
            LOGGER.debug("Department: {}", employee.getDepartment());
            LOGGER.debug("Skills: {}", employee.getSkillList());
        }
        LOGGER.info("testGetEmployee end");
    }

    private void testAddEmployee() {
        LOGGER.info("testAddEmployee start");
        Department department = departmentService.get(1);
        Employee employee = new Employee();
        employee.setName("Priya");
        employee.setSalary(65000.0);
        employee.setPermanent(Boolean.TRUE);
        employee.setDateOfBirth(LocalDate.of(1996, 4, 18));
        employee.setDepartment(department);
        employeeService.save(employee);
        LOGGER.debug("Added employee: {}", employee);
        LOGGER.info("testAddEmployee end");
    }

    private void testUpdateEmployee() {
        LOGGER.info("testUpdateEmployee start");
        Employee employee = employeeService.get(1);
        Department department = departmentService.get(2);
        if (employee != null && department != null) {
            employee.setDepartment(department);
            employeeService.save(employee);
            LOGGER.debug("Updated employee: {}", employee);
        }
        LOGGER.info("testUpdateEmployee end");
    }

    private void testGetDepartment() {
        LOGGER.info("testGetDepartment start");
        Department department = departmentService.get(1);
        LOGGER.debug("Department: {}", department);
        if (department != null) {
            LOGGER.debug("Employee list: {}", department.getEmployeeList());
        }
        LOGGER.info("testGetDepartment end");
    }

    private void testAddSkillToEmployee() {
        LOGGER.info("testAddSkillToEmployee start");
        Employee employee = employeeService.get(1);
        Skill skill = skillService.get(2);
        if (employee != null && skill != null) {
            employee.getSkillList().add(skill);
            employeeService.save(employee);
            LOGGER.debug("Employee after adding skill: {}", employee);
        }
        LOGGER.info("testAddSkillToEmployee end");
    }
}