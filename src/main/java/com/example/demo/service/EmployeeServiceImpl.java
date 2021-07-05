package com.example.demo.service;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private TransactionTemplate transactionTemplate;

  //eg transaction - Annotate whole method with method wide transaction boundry
  @Transactional
  @Override
  public void saveEmployeeTestMethodLevelTransaction() {
    EmployeeEntity entity1 = new EmployeeEntity();
    entity1.setName("employee3");
    entity1.setAge(35.6f);
    entity1.setSalary(1000);
    entity1.setYears(5);
    employeeRepository.save(entity1);
    EmployeeEntity entity2 = new EmployeeEntity();
    entity2.setName("employee4");
    entity2.setAge(35.6f);
    entity2.setSalary(1000);
    entity2.setYears(5);
    employeeRepository.save(entity2);
  }

  //Using Springs Transaction template.Utilizes PlatformTransactionManagerInternally
  @Override
  public void saveEmployeeTestProgTansactionManagement(){
   transactionTemplate.execute(new TransactionCallbackWithoutResult() {
     @Override
     protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
       EmployeeEntity entity1 = new EmployeeEntity();
       entity1.setName("employee6");
       entity1.setAge(35.6f);
       entity1.setSalary(1000);
       entity1.setYears(5);
       employeeRepository.save(entity1);
       EmployeeEntity entity2 = new EmployeeEntity();
       entity2.setName("employee7");
       entity2.setAge(35.6f);
       entity2.setSalary(1000);
       entity2.setYears(5);
       employeeRepository.save(entity2);

     }
   });

  }

}
