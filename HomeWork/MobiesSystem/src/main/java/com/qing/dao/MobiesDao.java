package com.qing.dao;

import com.qing.entity.Mobile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MobiesDao {
    private static Map<Integer, Mobile> mobies = new HashMap<>();

    static {
        mobies.put(1, new Mobile(1, "HuaWei", "P40", 4999.9, "images/huawei.png"));
        mobies.put(2, new Mobile(2, "Apple", "iphone 12", 6999.9, "images/iphone.png"));
        mobies.put(3, new Mobile(3, "XiaoMi", "K40", 3999.98, "images/xiaomi.png"));
        mobies.put(4, new Mobile(4, "Honor", "V40", 3999.1, "images/honor.png"));
    }

    public static List<Mobile> findAll() {
        List all = new ArrayList();
        all.add(new Mobile(1, "HuaWei", "P40", 4999.9, "images/huawei.png"));
        all.add(new Mobile(2, "Apple", "iphone 12", 6999.9, "images/iphone.png"));
        all.add(new Mobile(3, "XiaoMi", "K40", 3999.98, "images/xiaomi.png"));
        all.add(new Mobile(4, "Honor", "V40", 3999.1, "images/honor.png"));
        return all;
    }

    public static Mobile findByid(int id) {
        return mobies.get(id);
    }
}
