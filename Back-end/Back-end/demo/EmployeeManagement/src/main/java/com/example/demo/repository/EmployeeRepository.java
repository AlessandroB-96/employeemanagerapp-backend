package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//For JpaRepository, we have to specify which Class this repository is for (Employee in our case) and the type of our primary key (Which is a Long id)
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //Spring is able to interprets this language as an SQL query: delete Employee by id
    //This is a query method
    void deleteEmployeeById(Long id);

    //Spring is able to interprets this language as an SQL query: SELECT Employee by id WHERE id = 'id'
    //This is a query method
    Optional<Employee> findEmployeeById(Long id);

}
