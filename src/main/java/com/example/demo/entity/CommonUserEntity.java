package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CommonUser")
public class CommonUserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "commonuserid", nullable = false)
  public Integer getCommonUserId() {
    return commonUserId;
  }

  public void setCommonUserId(Integer commonUserId) {
    this.commonUserId = commonUserId;
  }

  private Integer commonUserId;

  @Column(name = "username", nullable = false)
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  private String userName;




}
