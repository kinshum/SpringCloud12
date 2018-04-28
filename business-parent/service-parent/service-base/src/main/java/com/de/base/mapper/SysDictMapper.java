package com.de.base.mapper;

import java.util.List;

import com.de.base.entity.SysDict;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface SysDictMapper {

	List<SysDict> selectSysDictList();

	SysDict selectByPrimaryKey (@Param("id") String id);

}
