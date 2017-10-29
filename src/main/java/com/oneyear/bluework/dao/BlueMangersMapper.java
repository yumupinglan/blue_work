package com.oneyear.bluework.dao;

import com.oneyear.bluework.model.BlueMangers;

public interface BlueMangersMapper {
    public int deleteByPrimaryKey(String id);

    public int insert(BlueMangers record);

    public int insertSelective(BlueMangers record);

    public BlueMangers selectByPrimaryKey(String id);

    public int updateByPrimaryKeySelective(BlueMangers record);

    public int updateByPrimaryKey(BlueMangers record);
    
   public BlueMangers findByUserName(String name);
}