package com.example.demo.service;

import com.example.demo.repository.CommonOrganizationCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonOrganizationServiceImpl implements CommonOrganizationService {

  @Autowired
  private CommonOrganizationCustomRepository commonOrganizationCustomRepository;

  @Override
  public String findDbMoniker(int orgId) {
    return commonOrganizationCustomRepository.findDbMoniker(orgId);
  }
}
