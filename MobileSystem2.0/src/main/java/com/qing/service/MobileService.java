package com.qing.service;

import com.github.pagehelper.PageInfo;
import com.qing.entity.Mobile;

import java.util.HashMap;
import java.util.List;

public interface MobileService {
    List<Mobile> findAll();

    Mobile findById(int id);

    void addMobile(Mobile mobile);

    void updateMobile(Mobile mobile);

    void deleteMobile(int id);

    List<Mobile> searchMobile(HashMap<Object, Object> map);

    PageInfo<Mobile> findAllMobilePage(int pageNum,int pageSize);

    void delCheck(int[] ids);

    PageInfo<Mobile> searchMobilePage(int pageNum, int pageSize, HashMap<Object, Object> map);
}
