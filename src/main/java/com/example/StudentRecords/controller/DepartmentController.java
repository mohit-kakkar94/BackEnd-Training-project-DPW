package com.example.StudentRecords.controller;

import com.example.StudentRecords.entity.Student;
import com.example.StudentRecords.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/department")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/getListOfDepartments")
    public List<String> getListOfDepartments() {

        List<String> deparments = null;

        try {
            deparments = departmentService.getListOfDepartments();
        } catch (Exception e) {
            log.info("Couldn't fetch the list of departments: ", e.getMessage());
        }

        return deparments;
    }


}
