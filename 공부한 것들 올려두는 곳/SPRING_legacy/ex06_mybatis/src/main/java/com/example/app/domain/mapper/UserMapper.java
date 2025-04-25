package com.example.app.domain.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import com.example.app.domain.dto.UserDto;

@Mapper
public interface UserMapper {
	@Insert(value="insert into tbl_memo values(#{id},#{text},#{writer},#{createAt})")
	void insert(UserDto dto1);
	
	@Update("update tbl_memo set text=#{text} where id=#{id}")
	public int update(UserDto dto);
	
	@Delete("delete from tbl_memo where id=#{id}")
	public int delete(String id);
	
	
}
