package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  @Override
  public String getName() {
    return "testname";
  }
}
