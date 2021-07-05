package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class CommonOrganizationCustomRepositoryImpl implements CommonOrganizationCustomRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public String findDbMoniker( int orgId) {
    Query query = entityManager.createNativeQuery("Select dbURL from CommonOrganization where orgId = :orgId");
    query.setParameter("orgId", orgId);
    String dbURL = (String) query.getSingleResult();
    return dbURL;
  }
}
