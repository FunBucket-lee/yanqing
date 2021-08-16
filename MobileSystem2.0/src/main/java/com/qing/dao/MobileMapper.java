package com.qing.dao;

import com.qing.entity.Mobile;

import java.util.HashMap;
import java.util.List;

public interface MobileMapper {
    List<Mobile> findAll();

    Mobile findById(int id);

    void addMobile(Mobile mobile);

    void updateMobile(Mobile mobile);

    void deleteMobile(int id);

    List<Mobile> searchMobile(HashMap<Object, Object> map);

    void delCheck(int[] ids);
}
