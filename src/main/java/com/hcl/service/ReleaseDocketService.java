package com.hcl.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.dto.EmployeeDto;
import com.hcl.exception.ResourceNotFoundException;
import com.hcl.model.Employee;
import com.hcl.repo.EmployeeRepository;
import com.hcl.util.ReleaseDocketExcelHelper;

@Service
public class ReleaseDocketService {

	@Autowired
	EmployeeRepository repository;

	public void save(MultipartFile file) {
		try {
			List<Employee> empList = ReleaseDocketExcelHelper.excelToEmployee(file.getInputStream());
			repository.saveAll(empList);
		} catch (IOException e) {
			throw new RuntimeException("fail to store excel data: " + e.getMessage());
		}
	}

	public ByteArrayInputStream load() {
		List<Employee> tutorials = repository.findAll();

		ByteArrayInputStream in = ReleaseDocketExcelHelper.empLoyeesToExcel(tutorials);
		return in;
	}

	public List<Employee> getAllTutorials() {
		return repository.findAll();
	}

	public Employee updateEmployee(String id, EmployeeDto employeeDetails) {
		Employee employee = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		employee.setBand(employeeDetails.getBand());
		employee.setSapId(employeeDetails.getSapId());
		employee.setFresherOrLateral(employeeDetails.getFresherOrLateral());
		employee.setEmpName(employeeDetails.getEmpName());
		employee.setProjectName(employeeDetails.getProjectName());
		employee.setBand(employeeDetails.getBand());
		employee.setReleaseDate(employeeDetails.getReleaseDate());
		employee.setDelimitationDateInRAS(employeeDetails.getDelimitationDateInRAS());
		employee.setReasonforRelease(employeeDetails.getReasonforRelease());
		employee.setPartOfRotation(employeeDetails.getPartOfRotation());
		employee.setPerformanceFeedback(employeeDetails.getPerformanceFeedback());
		employee.setNoOfMonthsWorked(employeeDetails.getNoOfMonthsWorked());
		employee.setBoardSkil(employeeDetails.getBoardSkil());
		employee.setSkillSet(employeeDetails.getSkillSet());
		employee.setExpInYrs(employeeDetails.getExpInYrs());
		employee.setContactNumber(employeeDetails.getContactNumber());
		employee.setCurrentLocation(employeeDetails.getCurrentLocation());
		employee.setLeavePlan(employeeDetails.getLeavePlan());
		employee.setReleaseRequestor(employeeDetails.getReleaseRequestor());
		employee.setStatus(employeeDetails.getStatus());

		return repository.save(employee);
	}

	public Employee addEmployee(Employee employeeDetails) {
		return repository.save(employeeDetails);

	}

	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	public Employee getEmployee(String id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
	}

	public void deleteEmployee(String id) {
		repository.deleteById(id);
	}
}
