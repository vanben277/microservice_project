package com.example.department_service.service.impl;

import com.example.department_service.entity.Department;
import com.example.department_service.form.DepartmentFilterForm;
import com.example.department_service.repository.DepartmentRepository;
import com.example.department_service.repository.specification.DepartmentSpecification;
import com.example.department_service.service.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements IDepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public Department getDepartmentById(int id) {
        return departmentRepository.findById(id).isPresent() ? departmentRepository.findById(id).get() : null;
    }

    @Override
    public Page<Department> getAllDepartments(
            Pageable pageable,
            String search,
            DepartmentFilterForm filterForm
    ) {
        Specification<Department> specification =
                DepartmentSpecification.build(search, filterForm);

        return departmentRepository.findAll(specification, pageable);
    }
}
