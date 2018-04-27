package com.de.base.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.de.base.mapper.SysDictMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;



@Service
public class SysDictService {
	
	@Autowired
	private SysDictMapper sysDictMapper;

	public List<Map<String, Object>> getSystemDictList(Map<String, String> map) {
		// TODO Auto-generated method stub
		String pageNum = map.get("pageNum");
		String pageSize = map.get("pageSize");
		Page<List<Map<String,Object>>> pageInfo = PageHelper.startPage(Integer.valueOf(pageNum), Integer.valueOf(pageSize));
		List<Map<String,Object>> data = sysDictMapper.selectAll();
		return data;
	}

}
