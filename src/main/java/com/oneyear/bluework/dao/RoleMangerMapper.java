package com.oneyear.bluework.dao;

import com.oneyear.bluework.model.RoleManger;

public interface RoleMangerMapper {
    int deleteByPrimaryKey(String id);

    int insert(RoleManger record);

    int insertSelective(RoleManger record);

    RoleManger selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RoleManger record);

    int updateByPrimaryKey(RoleManger record);
}