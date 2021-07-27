package com.yuravashchenko.spring.rest.dao;

import com.yuravashchenko.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);
}
