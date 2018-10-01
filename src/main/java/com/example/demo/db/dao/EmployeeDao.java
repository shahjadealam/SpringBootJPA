package com.example.demo.db.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.db.entity.Employee;
import com.example.demo.db.repository.EmployeeRepository;

@Repository
public class EmployeeDao {

	@Autowired
	EmployeeRepository employeeRepository;
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	public Employee getById(Long id) {
		// return employeeRepository.findById(id).orElseThrow(Exception::new);
		return employeeRepository.findById(id).get();
	}

	public void deleteById(Long id) {
		employeeRepository.deleteById(id);
	}

	public Employee update(Employee employee, Long id) {

		Employee emp = employeeRepository.findById(id).get();
		emp.setCity(employee.getCity());
		emp.setEmail(employee.getEmail());
		emp.setSalary(employee.getSalary());
		emp.setName(employee.getName());

		return employeeRepository.save(emp);
	}

	
	public Employee getByName(String name) {
		return employeeRepository.getByName(name);

	}

	public List<Employee> showSalary() {
		return employeeRepository.showSalary();
	}
	
}
