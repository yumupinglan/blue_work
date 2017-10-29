package com.oneyear.bluework.dao;

import com.oneyear.bluework.model.BlueJobhunter;

public interface BlueJobhunterMapper {
    int deleteByPrimaryKey(String id);

    int insert(BlueJobhunter record);

    int insertSelective(BlueJobhunter record);

    BlueJobhunter selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BlueJobhunter record);

    int updateByPrimaryKey(BlueJobhunter record);
}