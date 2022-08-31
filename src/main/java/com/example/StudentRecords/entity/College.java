package com.example.StudentRecords.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="College")
@Table(
        name = "college"
)
@Getter
@Setter
@NoArgsConstructor
public class College {

    @Id
    @SequenceGenerator(
            name="college_sequence",
            sequenceName = "college_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "college_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "college_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String collegeName;

    @Column(
            name = "state",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String state;

//    @OneToMany(
//            mappedBy = "department"
//    )
//    private List<Student> students = new ArrayList<>();

    public College(String collegeName, String state) {
        this.collegeName = collegeName;
        this.state = state;
    }

    @Override
    public String toString() {
        return "College{" +
                "id=" + id +
                ", collegeName='" + collegeName + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
