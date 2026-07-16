package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Department;
import com.cognizant.springlearn.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public Department get(int id) {
        Optional<Department> department = departmentRepository.findById(id);
        return department.orElse(null);
    }

    @Transactional
    public void save(Department department) {
        departmentRepository.save(department);
    }
}