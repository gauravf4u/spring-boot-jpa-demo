package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "[User]")
public class UserEntity {

  @Column(name = "username", nullable = false)
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  private String userName;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "userid", nullable = false)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  private Integer id;


  public UserEntity(){

  }



}
