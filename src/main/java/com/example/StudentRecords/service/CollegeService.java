package com.example.StudentRecords.service;

import com.example.StudentRecords.entity.College;
import com.example.StudentRecords.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CollegeService {

    @Autowired
    private CollegeRepository collegeRepository;

    public List<String> getListOfColleges() {
        List<College> colleges = collegeRepository.findAll();
        List<String> collegeNames = colleges.stream()
                .map(college -> college.getCollegeName())
                .collect(Collectors.toList());
        return collegeNames;
    }
}
