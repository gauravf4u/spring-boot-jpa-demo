package com.example.demo.controller;

import com.example.demo.config.DatabaseContextHolder;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.repository.EmployeeCustomRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.CommonOrganizationService;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

  private static final int ORG_ID = 718;

  @Autowired
  private CommonOrganizationService commonOrganizationService;

  @Autowired
  private EmployeeRepository employeeRepository;
  @Autowired
  private EmployeeCustomRepository employeeCustomRepository;
  @Autowired
  private EmployeeService employeeService;

  @GetMapping("/store/{name}")
  public String createEmployee(@PathVariable(value = "name") String name) {
    DatabaseContextHolder.setCurrentDbInContext(commonOrganizationService.findDbMoniker(ORG_ID));
    EmployeeEntity entity = new EmployeeEntity();
    entity.setName(name);
    entity.setAge(35.6f);
    entity.setSalary(1000);
    entity.setYears(5);
    employeeRepository.save(entity);
    return "Record Created Successfully";
  }

  @GetMapping("/test-transaction")
  public String createEmployeeInTransaction() {
    DatabaseContextHolder.setCurrentDbInContext(commonOrganizationService.findDbMoniker(ORG_ID));
    employeeService.saveEmployeeTestMethodLevelTransaction();
    return "Record Created Successfully";
  }

  @GetMapping("")
  public List<EmployeeEntity> findAll() {
    return employeeRepository.findAll();
  }

  @GetMapping("/{name}")
  public EmployeeEntity findByName(@PathVariable(value = "name") String name) {
    return employeeRepository.findEmployeeByName(name);
  }

  @GetMapping("/max-salary")
  public String findMaxSalary() {
    return employeeCustomRepository.findMaxSalary();
  }
}
