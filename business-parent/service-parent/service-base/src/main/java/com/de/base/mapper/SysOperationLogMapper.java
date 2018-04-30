package com.de.base.mapper;


import com.de.base.entity.SysOperationLog;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface SysOperationLogMapper {

    int insertSelective(SysOperationLog record);

    List<SysOperationLog> selectAll();

    SysOperationLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysOperationLog record);

}