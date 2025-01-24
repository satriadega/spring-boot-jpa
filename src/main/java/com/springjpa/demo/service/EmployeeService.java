package com.springjpa.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjpa.demo.entity.Employee;
import com.springjpa.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  public Optional<Employee> findById(String id) {
    return employeeRepository.findById(id);
  }

  public Employee save(Employee employee) {
    return employeeRepository.save(employee);
  }

  public void deleteById(String id) {
    employeeRepository.deleteById(id);
  }
}
