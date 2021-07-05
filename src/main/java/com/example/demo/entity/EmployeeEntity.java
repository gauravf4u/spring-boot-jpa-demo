package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class EmployeeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "employeeId", nullable = false)
  public int getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }

  @Column(name = "name", nullable = false)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  @Column(name = "salary", nullable = false)
  public float getSalary() {
    return salary;
  }

  public void setSalary(float salary) {
    this.salary = salary;
  }

  @Column(name = "age", nullable = false)
  public float getAge() {
    return age;
  }

  public void setAge(float age) {
    this.age = age;
  }

  @Column(name = "yearsInCompany", nullable = false)
  public float getYears() {
    return years;
  }

  public void setYears(float years) {
    this.years = years;
  }

  private int    employeeId;
  private String name;
  private float  salary;
  private float  age;
  private float  years;


}
