package com.example.StudentRecords.service;

import com.example.StudentRecords.entity.Student;
import com.example.StudentRecords.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findStudentsByName(String name) {
        List<Student> students = studentRepository.findStudentsByName(name);
        return students;
    }

    public Student findStudentByEmail(String email) {

        Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);

        if (studentOptional.isEmpty()) {
            return null;
        }

        return studentOptional.get();
    }

    public List<Student> findStudentsByDepartmentName(String departmentName) {
        List<Student> students = studentRepository.findStudentsByDepartmentName(departmentName);
        return students;
    }

    public List<Student> findStudentsByCollegeName(String collegeName) {
        List<Student> students = studentRepository.findStudentsByCollegeName(collegeName);
        return students;
    }

    public List<Student> findStudentsByDepartmentNameAndCollegeName(String departmentName, String collegeName) {
        List<Student> students = studentRepository.
                findStudentsByDepartmentNameAndCollegeName(departmentName, collegeName);
        return students;
    }

    public List<Student> findStudentsByNameAndDepartmentNameAndCollegeName(String name,
                                                                           String departmentName,
                                                                           String collegeName) {
        List<Student> students = studentRepository.
                findStudentsByNameAndDepartmentNameAndCollegeName(name, departmentName, collegeName);
        return students;
    }

}
