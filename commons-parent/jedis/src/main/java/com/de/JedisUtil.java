package com.de;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import io.codis.jodis.JedisResourcePool;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * redis缓存工具类
 * @author jt
 *
 */
public final class JedisUtil {
	/**
	 * redis 连接池
	 */
	private JedisPool jedisPool = null;
	
	/**
	 * codis 连接池
	 */
	private JedisResourcePool jedisPool2 = null;
	
	private boolean codisMode = false;
	
	private static JedisUtil instance = null;
	
	private JedisUtil(JedisPool jedisPool ,JedisResourcePool jedisPool2) {
		this.jedisPool = jedisPool;
		this.jedisPool2 = jedisPool2;
		this.codisMode = this.jedisPool2 != null;
	}
	
	public static JedisUtil getInstance(JedisPool jedisPool ,JedisResourcePool jedisPool2) {
		if(instance == null) {
			instance = new JedisUtil(jedisPool,jedisPool2);
		}
		return instance;
	}

	/**
	 * 设置缓存
	 * @param key 键
	 * @param value 值
	 */
	public void set(String key, String value) {
		Jedis jedis = getJedis();
		try {
			jedis.set(key, value);
		} finally {
			jedis.close();
		}
	}
	/**
	 * @param key 键
	 * @param minute 过期时间 单位分钟
	 * @param value 值
	 */
	public void setex(String key, int minute, String value) {
		Jedis jedis = getJedis();
		try {
			jedis.setex(key, minute * 60, value);
		} finally {
			jedis.close();
		}
	}
	
	/**
	 * 设置过期时间
	 * @param key 键
	 * @param minute 过期时间 单位分钟
	 */
	public void expire(String key, int minute) {
		Jedis jedis = getJedis();
		try {
			jedis.expire(key, minute * 60);
		} finally {
			jedis.close();
		}
	}
	
	/**
	 * 是否存在键值
	 * @param key 键
	 * @return ture / false
	 */
	public boolean exists(String key) {
		Jedis jedis = getJedis();
		try {
			return jedis.exists(key);
		} finally {
			jedis.close();
		}
	}
	
	/**
	 * 取得缓存值
	 * @param key 键
	 * @return 返回缓存值
	 */
	public String get(String key) {
		Jedis jedis = getJedis();
		try {
			return jedis.get(key);
		} finally {
			jedis.close();
		}
	}
	/**
	 * 模糊查询缓存中key值
	 * @param key值匹配，例如   8888*
	 * @return 返回key值
	 */
	public Set<String> getKeys(String keyPattern) {
		Jedis jedis = getJedis();
		try {
			return jedis.keys(keyPattern);
		} finally {
			jedis.close();
		}
	}
	/**
	 * 清除缓存
	 * @param key 键
	 */
	public void del(String key) {
		Jedis jedis = getJedis();
		try {
			jedis.del(key);
		} finally {
			jedis.close();
		}
	}
	/**
	 * 
	* @Title:  setAddSets
	* @Description: set<String> 数据类型添加
	* @author zhangxianjiang
	* @param key
	* @param members  
	* @throws
	 */
	public void setAddSets(String key, String members) {
		Jedis jedis = getJedis();
		try {
			jedis.sadd(key, members);
		} finally {
			jedis.close();
		}
	}
	/**
	 * 
	* @Title:  removeMembers
	* @Description: set<String> 数据类型添加
	* 移除某个数据
	* @author zhangxianjiang
	* @param key
	* @param members  
	* @throws
	 */
	public long removeMembers(String key, String members) {
		Jedis jedis = getJedis();
		try {
			return jedis.srem(key, members);
		} finally {
			jedis.close();
		}
	}
	/**
	 * 
	* @Title:  countMembers
	* @Description: set<String> 
	* 计算数据总数
	* @author zhangxianjiang
	* @param key
	* @param members  
	* @throws
	 */
	public long countMembers(String key) {
		Jedis jedis = getJedis();
		try {
			return jedis.scard(key);
		} finally {
			jedis.close();
		}
	}
	/**
	 * 
	* @Title:  getAllMembers
	* @Description: set<String> 数据类型
	* 获取key值  得所有成员
	* @author zhangxianjiang
	* @param key
	* @param members  
	* @throws
	 */
	public Set<String>  getAllMembers(String key) {
		Jedis jedis = getJedis();
		Set<String> strSet = new HashSet<String>();
		try {
			strSet = jedis.smembers(key);
		} finally {
			jedis.close();
		}
		return strSet;
	}
	/**
	 * 
	* @Title:  existsSet
	* @Description: set<String> 数据类型
	* 判断是否包含某个成员
	* @author zhangxianjiang
	* @param key
	* @param members  
	* @throws
	 */
	public boolean  existsSet(String key, String member) {
		Jedis jedis = getJedis();
		try {
			return jedis.sismember(key, member);
		} finally {
			jedis.close();
		}
	}
	/**
	 * zhangxianjiang
	 * redis中存放hash值数据
	 * 
	 * @param key
	 * @param membersId
	 * @param members
	 * @return
	 */
	public long setAddHash(String key, String  membersId, String members) {
		Jedis jedis = getJedis();
		long count = 0l;
		try {
			count = jedis.hset(key, membersId, members);
		} finally {
			jedis.close();
		}
		return count;
	}
	/**
	 * getHash
	 * zhangxianjiang
	 * 获取redis中hash中某个key的数据
	 * @param key
	 * @param membersId
	 * @return
	 */
	public String getHash(String key, String  membersId) {
		Jedis jedis = getJedis();
		try {
			return jedis.hget(key, membersId);
		} finally {
			jedis.close();
		}
	}
	/**
	 * delHash
	 * 删除redis中hash-key中的某条数据
	 * @param key
	 * @param membersId
	 * @return
	 */
	public long delHash(String key, String  membersId) {
		Jedis jedis = getJedis();
		try {
			return jedis.hdel(key, membersId);
		} finally {
			jedis.close();
		}
	}
	/**
	 *getHashAllData
	 *zhangxianjiang
	 *获取某个key的所有hash数据 
	 * @param key
	 * @return
	 */
	public Map<String, String> getHashAllData(String key) {
		Jedis jedis = getJedis();
		try {
			return jedis.hgetAll(key);
		} finally {
			jedis.close();
		}
	}
	private Jedis getJedis() {
		if(this.codisMode) {
			return jedisPool2.getResource();
		} else {
			return jedisPool.getResource();
		}
	}
}
