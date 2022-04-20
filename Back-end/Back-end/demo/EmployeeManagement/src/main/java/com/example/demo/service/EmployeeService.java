package com.example.demo.service;


import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//We mark beans with @Service to indicate that they're holding the business logic
//Spring, with this annotation, knows that this object EmployeeService will be injected into another one, so it creates this object like a Singleton (ONLY ONE instance)
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    //Here, im Injecting EmployeeRepository into EmployeeService; I'm not using "new" keyword to instantiate a new Object, instead i will Inject the dependency
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //Methods

    //Method that return a list with all the employees in the db; its type is List of Employee, and it has no input parameters
    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    //Method that add an employee; its type is Employee and accept an Employee object as a parameter
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    //Method that update an employee; its type is Employee and accept an Employee object as a parameter
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    //Method that find an employee  with the given id; its type is Employee and accept a Long id as a parameter
    public Employee findEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id: " + id + " was not found!"));
        //If an employee is NOT found with the given id, throw an exception!
    }

    //Method that delete an employee with the given id; its type is void (doesn't return anything) and accept a Long id as a parameter
    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }

}