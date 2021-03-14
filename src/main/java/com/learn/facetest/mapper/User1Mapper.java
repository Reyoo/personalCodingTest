package com.learn.facetest.mapper;

import com.learn.facetest.model.User1;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface User1Mapper {
    int insert(User1 record);
    User1 selectByPrimaryKey(Integer id);
    //其他方法省略...
}