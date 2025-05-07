package com.example.demo.domain.mapper;

import com.example.demo.domain.dto.UserDto;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;



@Mapper
public interface UserMapper {
	@Insert(value="insert into tbl_user values(#{userid},#{username},#{password})")
	void insert(UserDto dto1);
	
	@Update("update tbl_user set where id=#{id}")
	public int update(UserDto dto);
	
	@Delete("delete from tbl_user where userid=#{userid}")
	public int delete(@Param("userid") String userid);
	
	
	@Select("select * from tbl_user where userid=#{userid} ")
	public UserDto selectAt(String userid);
	
	@Select("select * from tbl_user")
	public List<UserDto> selectAll();
	
	// xml
	public List<Map<String,Object>> selectAllResultMapXml();
	
}
