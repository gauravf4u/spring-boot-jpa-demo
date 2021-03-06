package com.example.demo.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MultiRoutingDataSource  extends AbstractRoutingDataSource {
  @Override
  protected Object determineCurrentLookupKey() {
      // invoked to find the currentDB in current thread's context
    return DatabaseContextHolder.getCurrentDbInContext();
  }
}