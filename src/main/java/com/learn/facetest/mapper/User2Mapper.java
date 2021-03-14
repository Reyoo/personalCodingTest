package com.learn.facetest.mapper;

import com.learn.facetest.model.User2;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface User2Mapper {

    int insert(User2 record);
    User2 selectByPrimaryKey(Integer id);

    //其他方法省略...
}