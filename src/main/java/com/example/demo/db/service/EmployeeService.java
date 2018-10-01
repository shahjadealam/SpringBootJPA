package com.example.demo.db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.db.dao.EmployeeDao;
import com.example.demo.db.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	public void saveEmployee(Employee employee) {
		employeeDao.saveEmployee(employee);
	}

	public List<Employee> getAllEmployee() {
		return employeeDao.getAllEmployee();
	}

	public Employee getById(Long id) {
		// return employeeDao.findById(id).orElseThrow(Exception::new);
		return employeeDao.getById(id);
	}

	public void deleteEmp(Long id) {
		employeeDao.deleteById(id);
	}

	public Employee update(Employee employee, Long id) {

		return employeeDao.update(employee, id);
	}

	public Employee getByName(String name) {
		return employeeDao.getByName(name);

	}

	public List<Employee> showSalary() {
		return employeeDao.showSalary();
	}
}
