package com.example.demo.repository;

import com.example.demo.entity.UserEntity;

import java.util.List;

public interface UserCustomRepository {
   List<UserEntity> findLockedUser();
}
