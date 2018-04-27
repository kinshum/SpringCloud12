package com.de.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.de.transport.InvokerResult;

@RestController
@RequestMapping(value = "/sysDict")
public class SysDictController {
	@Autowired
	private RestTemplate restTemplate;
	
	
	
	@RequestMapping(value = "/list")
	public InvokerResult getSysDictList(@RequestParam (value="pageSize", defaultValue="10", required=false) String pageSize,
			@RequestParam (value="pageNum", defaultValue="10", required=false) String pageNum) {
		InvokerResult result = new InvokerResult();
		String url = String.format("http://service-base/%s", "sysDict/getSystemDictList");
		Map<String,String> map = new HashMap<>();
		map.put("pageSize", pageSize);
		map.put("pageNum", pageNum);
		return restTemplate.postForEntity(url,map,InvokerResult.class).getBody();

	}
	

}
