package com.jade.sbp.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jade.sbp.domain.User;

public interface UserMapper {
	@Select("select * from User where userID=#{userID}")
	public String getUname(@Param("userID") String uid) throws Exception;
	
	public User getLoginInfo(@Param("userID") String uid) throws Exception;
}
