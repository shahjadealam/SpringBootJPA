package com.example.demo.db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.entity.Employee;
import com.example.demo.db.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/addemployee", method = RequestMethod.POST)
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
		return ResponseEntity.ok("New Employee Added");

	}

	@RequestMapping(value = "/getallemployee", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAllEmployee() {

		return ResponseEntity.ok(employeeService.getAllEmployee());
	}

	@RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
	public ResponseEntity<Employee> getById(@PathVariable Long id) {
		return ResponseEntity.ok(employeeService.getById(id));
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> deleteEmp(@PathVariable(value = "id") Long id) {
		employeeService.deleteEmp(id);
		return ResponseEntity.ok("Deleted with Employee ID-->" + id);

	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Employee> update(@RequestBody Employee employee, @PathVariable Long id) {
		Employee updatedEmp = employeeService.update(employee, id);
		return ResponseEntity.ok(updatedEmp);
	}

	@RequestMapping(value = "/getbyname/{name}", method = RequestMethod.GET)
	public ResponseEntity<Employee> getByName(@PathVariable String name) {

		return ResponseEntity.ok(employeeService.getByName(name));
	}

	@RequestMapping(value = "/showsalary", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> showSalary() {

		return ResponseEntity.ok(employeeService.showSalary());
	}
}
