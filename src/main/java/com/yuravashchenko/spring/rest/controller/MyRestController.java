package com.yuravashchenko.spring.rest.controller;

import com.yuravashchenko.spring.rest.entity.Employee;
import com.yuravashchenko.spring.rest.exception_handling.EmployeeIncorrectData;
import com.yuravashchenko.spring.rest.exception_handling.NoSuchEmployeeException;
import com.yuravashchenko.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class MyRestController {

    private final EmployeeService employeeService;

    public MyRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee showEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);

        if (Objects.isNull(employee)) {
            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in Database");
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);

        if (Objects.isNull(employee)) {
            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in Database");
        }

        employeeService.deleteEmployee(id);
        return "Employee with ID = " + id + " was deleted";
    }
}
