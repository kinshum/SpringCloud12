package com.de.repository;


import com.de.entity.Entity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 *
 * @author jensen 
 * @description es
 * @date 2018/5/2 18:32
 * @param
 * @return 
 */ 
public interface EntityRepository extends ElasticsearchRepository<Entity,Long> {

}
