package com.example.demo.config;

public class DatabaseContextHolder {
  //A class using a ThreadLocal variable to fetch and set the current db in a current thread
  private static final ThreadLocal<String> dbContextHolder = new ThreadLocal<>();
  public static void setCurrentDbInContext(String dbName){
    dbContextHolder.set(dbName);
  }
  public static String getCurrentDbInContext(){
    return dbContextHolder.get();
  }
  public static void clean(){
    dbContextHolder.remove();
  }

}
