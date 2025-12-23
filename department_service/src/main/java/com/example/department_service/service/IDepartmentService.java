package com.example.department_service.service;

import com.example.department_service.entity.Department;
import com.example.department_service.form.DepartmentFilterForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDepartmentService {

    Department getDepartmentById(int id);

    Page<Department> getAllDepartments(Pageable pageable, String search, DepartmentFilterForm departmentFilterForm);
}
