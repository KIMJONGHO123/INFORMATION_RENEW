package com.example.app.domain.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.app.domain.dto.UserDto;

@Mapper
public interface UserMapper {
	@Insert(value="insert into tbl_user values(#{username},#{password},#{role})")
	public int insert(UserDto dto1);
	
//	@Update("update user_table set password= #{password}, rol=#{role} where username=#{username}")
//	public int update(UserDto dto);
	
//	@Delete("delete from user_table where username=#{username}")
//	public int delete(@Param("username") String username);
	
	
	@Select("select * from tbl_user where username=#{username} ")
	public UserDto selectAt(String username);
	
//	@Select("select * from user_table")
//	public List<UserDto> selectAll();
	
//	// xml
//	public List<Map<String,Object>> selectAllResultMapXml();
	
}
