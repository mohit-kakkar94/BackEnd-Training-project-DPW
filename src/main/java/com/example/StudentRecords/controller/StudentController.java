package com.example.StudentRecords.controller;

import com.example.StudentRecords.entity.Student;
import com.example.StudentRecords.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/student")
@Slf4j
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/getStudentsByName/{name}")
    public List<Student> getStudentsByName(@PathVariable("name") String name) {

        List<Student> students = null;

        try {
            students = studentService.findStudentsByName(name);
        } catch (Exception e) {
            log.info("Couldn't fetch students by name: ", e.getMessage());
        }

        return students;
    }

    @GetMapping("/getStudentByEmail/{email}")
    public Student getStudentByEmail(@PathVariable("email") String email) {

        Student student = null;

        try {
            student = studentService.findStudentByEmail(email);
        } catch (Exception e) {
            log.info("Couldn't fetch student by email: ", e.getStackTrace());
        }

        return student;
    }

    @GetMapping("/getStudentsByDepartment/{departmentName}")
    public List<Student> getStudentsByDepartmentName(@PathVariable("departmentName") String departmentName) {

        List<Student> students = null;

        try {
            students = studentService.findStudentsByDepartmentName(departmentName);
        } catch (Exception e) {
            log.info("Couldn't fetch students by department name: ", e.getStackTrace());
        }

        return students;

    }

    @GetMapping("/getStudentsByCollege/{collegeName}")
    public List<Student> getStudentsByCollegeName(@PathVariable("collegeName") String collegeName) {

        List<Student> students = null;

        try {
            students = studentService.findStudentsByCollegeName(collegeName);
        } catch (Exception e) {
            log.info("Couldn't fetch students by college name: ", e.getStackTrace());
        }

        return students;

    }

    @GetMapping("/getStudentsByDepartmentNameAndCollegeName/{departmentName}/{collegeName}")
    public List<Student> getStudentsByDepartmentNameAndCollegeName(@PathVariable("departmentName") String departmentName,
                                                                   @PathVariable("collegeName") String collegeName) {

        List<Student> students = null;

        try {
            students = studentService.
                    findStudentsByDepartmentNameAndCollegeName(departmentName, collegeName);
        } catch (Exception e) {
            log.info("Couldn't fetch students by department name and college name: ", e.getStackTrace());
        }

        return students;

    }

    @GetMapping("/getStudentsByNameAndDepartmentNameAndCollegeName/{name}/{departmentName}/{collegeName}")
    public List<Student> getStudentsByNameAndDepartmentNameAndCollegeName(@PathVariable("name") String name,
                                                                          @PathVariable("departmentName") String departmentName,
                                                                          @PathVariable("collegeName") String collegeName) {

        List<Student> students = null;

        try {
            students = studentService.
                    findStudentsByNameAndDepartmentNameAndCollegeName(name, departmentName, collegeName);
        } catch (Exception e) {
            log.info("Couldn't fetch students by name and department name and college name: ", e.getStackTrace());
        }

        return students;

    }

}
