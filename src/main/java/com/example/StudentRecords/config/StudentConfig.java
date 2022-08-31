package com.example.StudentRecords.config;

import com.example.StudentRecords.entity.College;
import com.example.StudentRecords.entity.Department;
import com.example.StudentRecords.entity.Student;
import com.example.StudentRecords.repository.CollegeRepository;
import com.example.StudentRecords.repository.DepartmentRepository;
import com.example.StudentRecords.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository,
                                        DepartmentRepository departmentRepository,
                                        CollegeRepository collegeRepository) {

        return args -> {

            College iitK = new College("Indian Institute of Technology, Kanpur", "UP");
            collegeRepository.save(iitK);
            College iitB = new College("Indian Institute of Technology, Bombay", "Maharashtra");
            collegeRepository.save(iitB);
            College iiitB = new College("International Institute of Information Technology, Bangalore", "Karnataka");
            collegeRepository.save(iiitB);
            College nitA = new College("National Institute of Technology, Allahabad", "UP");
            collegeRepository.save(nitA);

            Department me = new Department("Mechanical Engineering");
            departmentRepository.save(me);
            Department ee = new Department("Electrical Engineering");
            departmentRepository.save(ee);
            Department cse = new Department("Computer Science & Engineering");
            departmentRepository.save(cse);
            Department ece = new Department("Electronics & Communication Engineering");
            departmentRepository.save(ece);

            Student student1 = new Student("Rahul", "Rahul@gmail.com", LocalDate.of(1990, Month.JANUARY, 5), "Delhi");
            student1.setCollege(iitK);
            student1.setDepartment(me);
            studentRepository.save(student1);

            Student student2 = new Student("Abhishek", "Abhishek@gmail.com", LocalDate.of(1998, Month.OCTOBER, 1), "Varanasi");
            student2.setCollege(iitB);
            student2.setDepartment(ee);
            studentRepository.save(student2);

            Student student3 = new Student("Anushka", "Anushka@gmail.com", LocalDate.of(1999, Month.NOVEMBER, 4), "Mumbai");
            student3.setCollege(iiitB);
            student3.setDepartment(cse);
            studentRepository.save(student3);

            Student student4 = new Student("Madhav", "Madhav@gmail.com", LocalDate.of(1996, Month.APRIL, 12), "Kanpur");
            student4.setCollege(nitA);
            student4.setDepartment(ece);
            studentRepository.save(student4);

            Student student5 = new Student("Rohit", "Rohit@gmail.com", LocalDate.of(1997, Month.MARCH, 15), "Bangalore");
            student5.setCollege(iitB);
            student5.setDepartment(cse);
            studentRepository.save(student5);

            Student student6 = new Student("Sheetal", "Sheetal@gmail.com", LocalDate.of(1995, Month.SEPTEMBER, 20), "Kanpur");
            student6.setCollege(iitB);
            student6.setDepartment(ee);
            studentRepository.save(student6);

        };

    }


}
