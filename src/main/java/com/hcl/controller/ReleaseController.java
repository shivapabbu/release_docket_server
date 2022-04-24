package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.dto.EmployeeDto;
import com.hcl.model.Employee;
import com.hcl.msg.ResponseMessage;
import com.hcl.service.ReleaseDocketService;
import com.hcl.util.ReleaseDocketExcelHelper;

@CrossOrigin("*")
@RestController
@RequestMapping("/")
public class ReleaseController {

	@Autowired
	ReleaseDocketService releseDocketService;

	@PostMapping("/employee/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";

		if (ReleaseDocketExcelHelper.hasExcelFormat(file)) {
			try {
				releseDocketService.save(file);
				message = "Uploaded the file successfully: " + file.getOriginalFilename();
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			} catch (Exception e) {
				message = e + "Could not upload the file: " + file.getOriginalFilename() + "!";
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
			}
		}

		message = "Please upload an excel file!";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	}

	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable String id, @RequestBody EmployeeDto employeeDetails) {

		Employee employee = releseDocketService.updateEmployee(id, employeeDetails);
		return ResponseEntity.ok(employee);
	}

	@PostMapping("/employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employeeDetails) {
		Employee employee = null;

		try {
			employee = releseDocketService.addEmployee(employeeDetails);
			// need to add in logger "Employee added successfully: " +
			// employeeDetails.getEmpName();
			return ResponseEntity.ok(employee);
		} catch (Exception e) {
			// need to add in logger "Could not save the employee: " +
			// employeeDetails.getSapId() + "!";
		}
		return ResponseEntity.ok(employee);

	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return releseDocketService.getAllEmployees();
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable String id) {

		Employee employee = releseDocketService.getEmployee(id);
		return ResponseEntity.ok(employee);
	}

	@DeleteMapping("employee/delete/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable String id) {
		releseDocketService.deleteEmployee(id);
		return ResponseEntity.ok(new Employee());
	}

}
