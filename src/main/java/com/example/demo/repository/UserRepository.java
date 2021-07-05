package com.example.demo.repository;

import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

  @Query(
      value = "SELECT userId,encpassword,question FROM [User]  WHERE username = 'FIPAdmin'",
      nativeQuery = true)
  UserEntity findAdminUser();
  @Query(value = "SELECT userId,encpassword,question FROM [User] where username = :name",
         nativeQuery = true)
  UserEntity findUserByName(@Param("name") String name);

}
