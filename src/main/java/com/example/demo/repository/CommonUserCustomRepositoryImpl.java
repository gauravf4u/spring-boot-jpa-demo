package com.example.demo.repository;

import com.example.demo.entity.CommonUserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CommonUserCustomRepositoryImpl implements CommonUserCustomRepository{

  @PersistenceContext
  private EntityManager entityManager;

  public List<CommonUserEntity> findCommonUsers(){
    Query                  query = entityManager.createNativeQuery("Select userName,commonUserId from CommonUser");
    List<CommonUserEntity> users = query.getResultList();
    return users;
  }

}
