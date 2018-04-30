package com.de.base.services;import java.util.List;import java.util.Map;import com.de.base.entity.SysDict;import com.de.base.entity.SysOperationLog;import com.de.base.mapper.SysOperationLogMapper;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.data.redis.core.RedisTemplate;import org.springframework.stereotype.Service;import com.de.base.mapper.SysDictMapper;import com.github.pagehelper.Page;import com.github.pagehelper.PageHelper;@Servicepublic class SysDictService {	@Autowired	private SysDictMapper sysDictMapper;	@Autowired	private SysOperationLogMapper sysOperationLogMapper;	@Autowired	private RedisTemplate redisTemplate;	public List<SysOperationLog> getSystemDictList(Map<String, String> map) {		// TODO Auto-generated method stub		String pageNum = map.get("pageNum");		String pageSize = map.get("pageSize");		Page<SysOperationLog> pageInfo = PageHelper.startPage(Integer.valueOf(pageNum), Integer.valueOf(pageSize));		List<SysOperationLog> cache = (List<SysOperationLog>) redisTemplate.opsForValue().get(pageNum+pageSize);		if(cache == null) {			cache = sysOperationLogMapper.selectAll();			redisTemplate.opsForValue().set(pageNum + pageSize, cache);		}		return cache;	}}