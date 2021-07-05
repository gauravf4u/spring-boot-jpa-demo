package com.example.demo.repository;

import com.example.demo.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {
  @Query(
      value = "SELECT name,age,yearsInCompany FROM Employee order by yearsInCompany desc",
      nativeQuery = true)
  List<EmployeeEntity> findOrderByYearsInCompany();
  @Query(value = "SELECT name,age,yearsInCompany,age FROM Employee order by age desc",
         nativeQuery = true)
  List<EmployeeEntity> findOrderByAge();

  @Query(value = "SELECT * FROM Employee where name=:name",
         nativeQuery = true)
  EmployeeEntity findEmployeeByName(@Param("name") String name);

}
