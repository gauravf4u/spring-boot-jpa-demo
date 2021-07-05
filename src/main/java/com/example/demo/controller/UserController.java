package com.example.demo.controller;

import com.example.demo.config.DatabaseContextHolder;
import com.example.demo.entity.CommonUserEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.CommonUserCustomRepository;
import com.example.demo.repository.UserCustomRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.CommonOrganizationService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  private UserRepository       userRepository;
  @Autowired
  private UserCustomRepository       userCustomRepository;
  @Autowired
  private CommonUserCustomRepository commonUserCustomRepository;
  @Autowired
  private CommonOrganizationService commonOrganizationService;

  private static final int ORG_ID = 718;

  @Autowired
  private UserService userService;
  @GetMapping("/all")
  public List<UserEntity> getAllEmployees() {
    //set client database dbMoniker to access client db.The default datasource points to Common database, so we need to call this inorder to access client db
    DatabaseContextHolder.setCurrentDbInContext(commonOrganizationService.findDbMoniker(ORG_ID));
    return userRepository.findAll();
  }

  @GetMapping("/admin")
  public UserEntity findAdminUser() {
    DatabaseContextHolder.setCurrentDbInContext(commonOrganizationService.findDbMoniker(ORG_ID));
    return userRepository.findAdminUser();
  }

  @GetMapping("/user/{name}")
  public UserEntity findByName(@PathVariable(value = "name") String name) {
    DatabaseContextHolder.setCurrentDbInContext(commonOrganizationService.findDbMoniker(ORG_ID));
    return userRepository.findUserByName(name);
  }

  @GetMapping("/locked")
  public List<UserEntity> getLockedUsers() {
    DatabaseContextHolder.setCurrentDbInContext(commonOrganizationService.findDbMoniker(ORG_ID));
    System.out.println(DatabaseContextHolder.getCurrentDbInContext());
    return userCustomRepository.findLockedUser();
  }
  //test to access common database entity
  @GetMapping("/commonuser")
  public List<CommonUserEntity> getUserFromCommon() {
    DatabaseContextHolder.setCurrentDbInContext("COMMONS");
    System.out.println(DatabaseContextHolder.getCurrentDbInContext());
    return commonUserCustomRepository.findCommonUsers();
  }

}
