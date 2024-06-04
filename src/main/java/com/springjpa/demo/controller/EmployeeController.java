package com.springjpa.demo.controller;

import com.springjpa.demo.entity.Employee;
import com.springjpa.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
  public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
    Optional<Employee> employee = employeeService.findById(id);
    return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
  }

  @PostMapping
  public ResponseEntity<Employee> createEmployee(
      @RequestParam("name") String name,
      @RequestParam("position") String position,
      @RequestParam("email") String email) {
    Employee employee = new Employee();
    employee.setName(name);
    employee.setPosition(position);
    employee.setEmail(email);
    return new ResponseEntity<>(employeeService.save(employee), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Employee> updateEmployee(
      @PathVariable Long id,
      @RequestParam("name") String name,
      @RequestParam("position") String position,
      @RequestParam("email") String email) {
    Optional<Employee> employeeOptional = employeeService.findById(id);
    if (employeeOptional.isPresent()) {
      Employee employee = employeeOptional.get();
      employee.setName(name);
      employee.setPosition(position);
      employee.setEmail(email);
      return ResponseEntity.ok(employeeService.save(employee));
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
    employeeService.deleteById(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
