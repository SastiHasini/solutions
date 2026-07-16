package com.cognizant.hqlquery.service;

import com.cognizant.hqlquery.model.Department;
import com.cognizant.hqlquery.repository.DepartmentRepository;
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
}