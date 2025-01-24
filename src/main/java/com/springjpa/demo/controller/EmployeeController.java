package com.springjpa.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springjpa.demo.entity.Employee;
import com.springjpa.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping
  public ResponseEntity<List<Employee>> getAllEmployees() {
    return ResponseEntity.ok(employeeService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
    Optional<Employee> employee = employeeService.findById(id);
    return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
  }

  @PostMapping
  public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
    return new ResponseEntity<>(employeeService.save(employee), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Employee> updateEmployee(@PathVariable String id, @RequestBody Employee employeeDetails) {
    Optional<Employee> employeeOptional = employeeService.findById(id);
    if (employeeOptional.isPresent()) {
      Employee employee = employeeOptional.get();
      employee.setName(employeeDetails.getName());
      employee.setPosition(employeeDetails.getPosition());
      employee.setEmail(employeeDetails.getEmail());
      return ResponseEntity.ok(employeeService.save(employee));
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteEmployee(@PathVariable String id) {
    employeeService.deleteById(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
