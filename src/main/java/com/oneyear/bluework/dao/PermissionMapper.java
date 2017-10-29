package com.oneyear.bluework.dao;

import java.util.List;

import com.oneyear.bluework.model.Permission;

public interface PermissionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    
    public List<Permission> findByAdminUserId(String userId);
    public List<Permission> findAll();
}