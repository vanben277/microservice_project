package com.example.department_service.controller;


import com.example.department_service.dto.DepartmentDTO;
import com.example.department_service.entity.Department;
import com.example.department_service.form.DepartmentFilterForm;
import com.example.department_service.service.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/departments")
public class DepartmentController {
    private final IDepartmentService departmentService;
    private final ModelMapper modelMapper;

    @GetMapping
    public Page<DepartmentDTO> getAllDepartment(
            Pageable pageable,
            @RequestParam(name = "search", required = false) String search, DepartmentFilterForm departmentFilterForm) {
        Page<Department> page = departmentService.getAllDepartments(pageable, search, departmentFilterForm);

        List<DepartmentDTO> dos = modelMapper.map(
                page.getContent(),
                new TypeToken<List<DepartmentDTO>>() {
                }.getType());

        Page<DepartmentDTO> departmentDTOS = new PageImpl<>(dos, pageable, page.getTotalElements());
        return departmentDTOS;

    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable("id") int id) {
        final Department departmentEntity = departmentService.getDepartmentById(id);
        final DepartmentDTO departmentDTO = modelMapper.map(
                departmentEntity,
                new TypeToken<DepartmentDTO>() {
                }.getType()
        );

        return ResponseEntity.ok(departmentDTO);
    }
}
