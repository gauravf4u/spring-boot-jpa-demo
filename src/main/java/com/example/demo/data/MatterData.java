package com.example.demo;

public class MatterData {

  public MatterData(String title, String matterType, String fileNo, String country, String status){
    this.title = title;
    this.matterType = matterType;
    this.fileNo = fileNo;
    this.country = country;
    this.status = status;
  }

  private String title;
  private String matterType;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getMatterType() {
    return matterType;
  }

  public void setMatterType(String matterType) {
    this.matterType = matterType;
  }

  public String getFileNo() {
    return fileNo;
  }

  public void setFileNo(String fileNo) {
    this.fileNo = fileNo;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  private String fileNo;
  private String country;
  private String status;
}
