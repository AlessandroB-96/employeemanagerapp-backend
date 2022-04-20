package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controller handles all the request received from a client (Web browser, postman) and fetches data from the server
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    ////Here, im Injecting EmployeeService into EmployeeController
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //Methods

    //Method that call findAllEmployee (a method of employeeService, inherited by the interface EmployeeRepository) that returns a list of all employees in the db.
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> allEmployees = employeeService.findAllEmployee();
        return new ResponseEntity<>(allEmployees, HttpStatus.OK);
        //ResponseEntity is a generic, so we have to specify between <> type of object we pass; we have then to return a
        //NEW ResponseEntity that will give our object and an HttpStatus which is useful to know status of our requests
    }

    //Method that call findEmployeeById (a query method of employeeService, specified in the interface EmployeeRepository) that finds the employee with the given id in the db.
    @GetMapping("/find/{id}")
    //We specify @PathVariable because we want to retrieve that information ( the id, in this case) from the path we have set = find/{id}
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    //Method that call addEmployee (a method of employeeService, that use .save by the interface EmployeeRepository) that creates the employee given in the body of the request into the db.
    @PostMapping ("/add")
    //We specify @RequestBody because we want to use data in the body of the http request to create a new employee
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
        //HttpStatus.CREATED notifies that we have created a new entity in the db
    }

    //Method that call updateEmployee (a method of employeeService, that use .save by the interface EmployeeRepository) that updates the employee given in the body of the request into the db.
    @PutMapping ("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    //??
    @Transactional
    //Method that call deleteEmployee (a query method of employeeService, specified by the interface EmployeeRepository) that deletes the employee with the given id in the db.
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
