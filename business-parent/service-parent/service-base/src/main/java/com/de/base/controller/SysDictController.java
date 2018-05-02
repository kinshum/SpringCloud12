package com.de.base.controller;import java.util.List;import java.util.Map;import com.de.base.entity.SysOperationLog;import com.de.entity.Entity;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.web.bind.annotation.RequestBody;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestParam;import org.springframework.web.bind.annotation.RestController;import com.de.base.services.SysDictService;import com.de.transport.InvokerResult;@RestController@RequestMapping(value = "/sysDict")public class SysDictController {	@Autowired	private SysDictService sysDictService;	/**	 * 获取系统字典列表（分页）	 * @param pageNum	 * @param pageSize	 * @return	 */	@RequestMapping(value = "/getSystemDictList")	public InvokerResult getSystemDictList(@RequestBody Map<String,String> map) {		InvokerResult result = new InvokerResult();		List<SysOperationLog> data = sysDictService.getSystemDictList(map);		result.setResult(data);		return result;	}	/**	 *	 * @author jensen	 * @description 数据同步索引	 * @date 2018/5/2 19:31	 * @param [map]	 * @return com.de.transport.InvokerResult	 */	@RequestMapping(value = "/addEntityForEsSerch")	public InvokerResult addEntityForEsSerch(@RequestBody Map<String,Object> map) {		InvokerResult result = new InvokerResult();		Entity entity = new Entity();		entity.setName((String)map.get("name"));		entity.setId(Long.valueOf((String)map.get("id")));		sysDictService.addEntity(entity);		return  result;	}	/**	 *	 * @author jensen	 * @description 根据关键字查询数据	 * @date 2018/5/2 19:35	 * @param [contentName]	 * @return com.de.transport.InvokerResult	 */    @RequestMapping(value = "/getListForEsSerch")	public InvokerResult getListForEsSerch(@RequestParam String contentName) {		InvokerResult result = new InvokerResult();		List<Entity> listByEsSerch = sysDictService.getListByEsSerch(contentName);		result.setResult(listByEsSerch);		return  result;	}}