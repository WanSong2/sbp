package com.songw.sbp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.songw.sbp.domain.User;

public interface UserMapper {
	@Select("select * from User where userID=#{userID}")
	public String getUname(@Param("userID") String uid) throws Exception;
	
	public User getLoginInfo(@Param("userID") String uid) throws Exception;
	
	@Select("select * from User limit 100")
	public List<User> getUsers();
}
