package com.example.StudentRecords.repository;

import com.example.StudentRecords.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findStudentsByName(String name);

    Optional<Student> findStudentByEmail(String email);

    @Query("SELECT s FROM Student s JOIN Department d ON s.department.id = d.id WHERE d.departmentName = ?1")
    List<Student> findStudentsByDepartmentName(String departmentName);

    @Query("SELECT s FROM Student s JOIN College c ON s.college.id = c.id WHERE c.collegeName = ?1")
    List<Student> findStudentsByCollegeName(String collegeName);

    @Query("SELECT s FROM Student s JOIN Department d ON s.department.id = d.id " +
            "JOIN College c ON s.college.id = c.id " +
            "WHERE d.departmentName = ?1 AND c.collegeName = ?2")
    List<Student> findStudentsByDepartmentNameAndCollegeName(String departmentName, String collegeName);

    @Query("SELECT s FROM Student s JOIN Department d ON s.department.id = d.id " +
            "JOIN College c ON s.college.id = c.id " +
            "WHERE s.name = ?1 AND d.departmentName = ?2 AND c.collegeName = ?3")
    List<Student> findStudentsByNameAndDepartmentNameAndCollegeName(String name,
                                                                    String departmentName,
                                                                    String collegeName);

}
