package com.de;import com.de.base.entity.SysDict;import com.de.base.mapper.SysDictMapper;import com.fasterxml.jackson.core.type.TypeReference;import org.junit.Test;import org.junit.runner.RunWith;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.boot.test.context.SpringBootTest;import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;import org.springframework.transaction.annotation.Transactional;import java.util.List;/** * @Author: jensen * @Description: * @Date: Created 15:41 2018/4/28 */@Transactional@RunWith(SpringJUnit4ClassRunner.class)@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)public class BaseTest {    @Autowired    private SysDictMapper sysDictMapper;    @Test    public void Test() {        List<SysDict> sysDicts = sysDictMapper.selectSysDictList();        String str = JsonConvertUtils.toJson(sysDicts);        List<SysDict> sysDicts1 = JsonConvertUtils.toObject(str, new TypeReference<List<SysDict>>() {        });    }}