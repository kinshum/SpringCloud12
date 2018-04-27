package com.de;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.codis.jodis.JedisResourcePool;
import redis.clients.jedis.JedisPool;

/**
 * @author abing
 * @create 2017-09-06
 */
public class ItemNumUtils {
	
	private static ItemNumUtils instance = null;

    private ItemNumUtils(){
    }
    
    private static JedisUtil jedisUtil=null;
    
    public static ItemNumUtils getInstance(JedisPool jedisPool ,JedisResourcePool jedisPool2) {
		if(instance == null) {
			instance = new ItemNumUtils();
			
		}
		if(null==jedisUtil){
		    jedisUtil = JedisUtil.getInstance(jedisPool, jedisPool2);
		}
		return instance;
	}
    
    /**
     *
     * @param type 分类
     * @return 商品编号
     */
    public synchronized String getItemNum(String type){

        if (isEmpty(type) || type.length() != 2){
            throw new RuntimeException("分类填写不正确");
        }
        //redis 存放的数据
        StringBuilder val = new StringBuilder();
        String date = currentDate();
        date = date.substring(2);
        val.append(date);
        String jVal = jedisUtil.get(type);
        if (!isBlank(jVal)){
            String jDate = jVal.substring(0,6);
            String jNum = jVal.substring(6);
            if (date.equals(jDate)){
                int jv = Integer.valueOf(jNum);
                String num = String.format("%04d" , ++jv);
                val.append(num);
            }else {
                val.append("0001");
            }
        }else {
            val.append("0001");
        }
        jedisUtil.set(type , val.toString());
        return type + val.toString();
    }
	public static String currentDate() {
		Date date = new Date();
		String str = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		str = df.format(date);
		return str;
	}
    public static boolean isBlank(String str){
        boolean b = false;
        if ("null".equals(str)){
            return true;
        }
        b = isEmpty(str);
        return b;
    }
    public static boolean isEmpty(String str){
        return  str == null || str.length() == 0;
    }
    
    
//    private static class SingletonHolder{
//        private static ItemNumUtils INSTANCE = new ItemNumUtils();
//    }
//    public static final ItemNumUtils getInstance(){
//
//        return SingletonHolder.INSTANCE;
//    }
}
