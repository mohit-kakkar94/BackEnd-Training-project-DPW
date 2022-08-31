package com.example.StudentRecords.controller;

import com.example.StudentRecords.service.CollegeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/college")
@Slf4j
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @GetMapping("/getListOfColleges")
    public List<String> getListOfColleges() {

        List<String> colleges = null;

        try {
            colleges = collegeService.getListOfColleges();
        } catch (Exception e) {
            log.info("Couldn't fetch the list of colleges: ", e.getMessage());
        }

        return colleges;
    }
}
