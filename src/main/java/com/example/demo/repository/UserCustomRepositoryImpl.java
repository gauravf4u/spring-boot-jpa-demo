package com.example.demo.repository;

import com.example.demo.entity.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserCustomRepositoryImpl implements UserCustomRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<UserEntity> findLockedUser() {
    Query            query = entityManager.createNativeQuery("Select userName from [User] where locked = 1");
    List<UserEntity> users = query.getResultList();
    return users;
  }

}
