package com.example.StudentRecords.service;

import com.example.StudentRecords.entity.Department;
import com.example.StudentRecords.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    public List<String> getListOfDepartments() {
        List<Department> departments = departmentRepository.findAll();
        List<String> departmentNames = departments.stream()
                .map(department -> department.getDepartmentName())
                .collect(Collectors.toList());
        return departmentNames;
    }
}
