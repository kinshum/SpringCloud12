package com.de.entity;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 *
 * @author jensen
 * @description 实体类型（测试）
 * @date 2018/5/2 19:12
 * @param
 * @return
 */
@Document(indexName="index_entity", type="tstype")
public class Entity implements Serializable{

	private static final long serialVersionUID = -763638353551774166L;

	private Long id;
	
	private String name;
	
	public Entity() {
		super();
	}
	
	public Entity(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
