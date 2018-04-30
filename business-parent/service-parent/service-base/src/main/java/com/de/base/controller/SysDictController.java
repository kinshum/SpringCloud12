package com.de.base.controller;

import java.util.List;
import java.util.Map;

import com.de.base.entity.SysDict;
import com.de.base.entity.SysOperationLog;
import com.de.base.mapper.SysOperationLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.de.base.services.SysDictService;
import com.de.transport.InvokerResult;

@RestController
@RequestMapping(value = "/sysDict")
public class SysDictController {
	
	@Autowired
	private SysDictService sysDictService;



	/**
	 * 获取系统字典列表（分页）
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/getSystemDictList")
	public InvokerResult getSystemDictList(@RequestBody Map<String,String> map) {
		InvokerResult result = new InvokerResult();
		List<SysOperationLog> data = sysDictService.getSystemDictList(map);
		result.setResult(data);
		return result;
		
	}

}
