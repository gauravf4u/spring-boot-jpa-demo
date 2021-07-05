package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class EmployeeCustomRepositoryImpl implements EmployeeCustomRepository{
  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public String findMaxSalary() {
    Query            query = entityManager.createNativeQuery("select MAX(Salary) from Employee");
    Double salary = (Double)query.getSingleResult();
    return salary.toString();
  }
}
