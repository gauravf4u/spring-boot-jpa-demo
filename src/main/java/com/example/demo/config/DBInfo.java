package com.example.demo.config;

public class DBInfo {


  public String getClientName() {
    return clientName;
  }

  public void setClientName(String clientName) {
    this.clientName = clientName;
  }

  public String getDbDriver() {
    return dbDriver;
  }

  public void setDbDriver(String dbDriver) {
    this.dbDriver = dbDriver;
  }

  public String getDbPassword() {
    return dbPassword;
  }

  public void setDbPassword(String dbPassword) {
    this.dbPassword = dbPassword;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getPoolSize() {
    return poolSize;
  }

  public void setPoolSize(String poolSize) {
    this.poolSize = poolSize;
  }

  public String getLoginUrl() {
    return loginUrl;
  }

  public void setLoginUrl(String loginUrl) {
    this.loginUrl = loginUrl;
  }

  public boolean isClawDB() {
    return clawDB;
  }

  public void setClawDB(boolean clawDB) {
    this.clawDB = clawDB;
  }

  public boolean isCommonDB() {
    return commonDB;
  }

  public void setCommonDB(boolean commonDB) {
    this.commonDB = commonDB;
  }

  public String getClientDomain() {
    return clientDomain;
  }

  public void setClientDomain(String clientDomain) {
    this.clientDomain = clientDomain;
  }

  private String clientName;
  private String dbDriver;
  private String dbPassword;
  private String userName;
  private String url;
  private String    poolSize;
  private String loginUrl;



  private boolean clawDB;
  private boolean commonDB;
  private String  clientDomain;

}
