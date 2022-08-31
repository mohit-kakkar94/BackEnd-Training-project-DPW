package com.example.StudentRecords.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Department")
@Table(
        name = "department"
)
@Getter
@Setter
@NoArgsConstructor
public class Department {

    @Id
    @SequenceGenerator(
            name="department_sequence",
            sequenceName = "department_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "department_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "department_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String departmentName;

//    @OneToMany(
//            mappedBy = "department"
//    )
//    private List<Student> students = new ArrayList<>();

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
