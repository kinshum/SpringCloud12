package com.de.base.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysDictMapper {
	
	@Select("SELECT sd.id,sd.dict_code,sd.dict_key,sd.dict_text,sd.dict_desc from sys_dict sd ")
	List<Map<String,Object>> selectAll();
	
	@Select("SELECT sd.id,sd.dict_code,sd.dict_key,sd.dict_text,sd.dict_desc from sys_dict sd  WHERE sd.id = = #{id}")
	Map<String,Object> selectByPrimaryKey (@Param("id") String id);

}
