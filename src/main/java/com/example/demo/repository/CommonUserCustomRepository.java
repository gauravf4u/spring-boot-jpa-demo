package com.example.demo.repository;

import com.example.demo.entity.CommonUserEntity;

import java.util.List;

public interface CommonUserCustomRepository {

  List<CommonUserEntity> findCommonUsers();
}
