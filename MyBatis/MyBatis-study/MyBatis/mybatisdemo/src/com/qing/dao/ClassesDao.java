package com.qing.dao;

import com.qing.entity.Classes;

import java.util.List;

public interface ClassesDao {
    List<Classes> findByNo(String cid);
}
