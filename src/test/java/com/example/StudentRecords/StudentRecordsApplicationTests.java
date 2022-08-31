package com.example.StudentRecords;

import com.example.StudentRecords.entity.College;
import com.example.StudentRecords.repository.CollegeRepository;
import com.example.StudentRecords.repository.DepartmentRepository;
import com.example.StudentRecords.service.CollegeService;
import com.example.StudentRecords.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class StudentRecordsApplicationTests {

	@Autowired
	private CollegeService collegeService;
	@MockBean
	private CollegeRepository collegeRepository;

	@Autowired
	private DepartmentService departmentService;
	@MockBean
	private DepartmentRepository departmentRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void getListOfCollegesTest() {

		when(collegeRepository.findAll()).thenReturn(
				Stream.of(
						new College("Indian Institute of Technology, Kanpur", "UP"),
						new College("Indian Institute of Technology, Bombay", "Maharashtra"),
						new College("International Institute of Information Technology, Bangalore", "Karnataka"),
						new College("National Institute of Technology, Allahabad", "UP")
						)
						.collect(Collectors.toList())
		);

		assertEquals(4, collegeService.getListOfColleges().size());
	}

}
