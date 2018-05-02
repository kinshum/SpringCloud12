package com.de.base.mapper;




import com.de.base.entity.SysTemp;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface SysTempMapper {


    int deleteByPrimaryKey(String id);

    int insert(SysTemp record);

    int insertSelective(SysTemp record);

    SysTemp selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysTemp record);

    int updateByPrimaryKey(SysTemp record);
}