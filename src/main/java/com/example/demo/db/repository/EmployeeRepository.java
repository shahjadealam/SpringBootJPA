package com.example.demo.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.db.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee getByName(String name);

	@Query("select E from Employee E where E.salary>50000")
	List<Employee> showSalary();

}
