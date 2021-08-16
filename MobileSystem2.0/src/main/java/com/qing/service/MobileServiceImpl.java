package com.qing.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qing.dao.MobileMapper;
import com.qing.entity.Mobile;
import com.qing.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;

public class MobileServiceImpl implements MobileService {
    SqlSession session = MyBatisUtil.getSession();
    MobileMapper mapper = session.getMapper(MobileMapper.class);

    @Override
    public List<Mobile> findAll() {
        return mapper.findAll();
    }

    @Override
    public Mobile findById(int id) {
        return mapper.findById(id);
    }

    @Override
    public void addMobile(Mobile mobile) {
        mapper.addMobile(mobile);
        session.commit();
    }

    @Override
    public void updateMobile(Mobile mobile) {
        mapper.updateMobile(mobile);
        session.commit();
    }

    @Override
    public void deleteMobile(int id) {
        mapper.deleteMobile(id);
        session.commit();
    }

    @Override
    public List<Mobile> searchMobile(HashMap<Object, Object> map) {
        return mapper.searchMobile(map);
    }

    @Override
    public PageInfo<Mobile> findAllMobilePage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Mobile> mobiles = mapper.findAll();
        PageInfo<Mobile> mobilePageInfo = new PageInfo<>(mobiles);
        return mobilePageInfo;
    }

    @Override
    public void delCheck(int[] ids) {
        mapper.delCheck(ids);
        session.commit();
    }

    @Override
    public PageInfo<Mobile> searchMobilePage(int pageNum, int pageSize, HashMap<Object, Object> map) {
        PageHelper.startPage(pageNum,pageSize);
        List<Mobile> mobiles = mapper.searchMobile(map);
        PageInfo<Mobile> pageInfo = new PageInfo<>(mobiles);
        return pageInfo;
    }
}
