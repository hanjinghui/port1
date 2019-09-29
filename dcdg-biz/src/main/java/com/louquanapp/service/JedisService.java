package com.louquanapp.service;

import com.huhuamin.common.HuhuaminException;
import com.louquanapp.utils.JedisUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Huhuamin
 * @Date: 2019年03月26日15:19:58
 * @email:175759041@qq.com
 * @Description: redis 业务处理
 */
@Service
public class JedisService {
    private final JedisPool jedisPool;
    public final static String VIRTUAL_COURSE_PREX = "_lc_vc_";

    /**
     * 默认3天
     */
    private final int EXPIRE_SECOND = 60 * 60 * 24 * 3;

    public JedisService(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }


    public void setKeyValue(String key, String value) {
        setKeyValue(key, value, EXPIRE_SECOND);
    }

    /**
     * 设置 list
     * @param key
     * @param list
     * @param <T>
     */
    public <T> void setList(String key ,List<T> list){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(1);
            jedis.set(key.getBytes(), JedisUtils.serialize(list));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedisPool.returnResource(jedis);
        }
    }


    /**
     * 获取list
     * @param <T>
     * @param key
     * @return list
     */
    public <T> List<T> getList(String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(1);
            if(jedis == null || !jedis.exists(key.getBytes())){
                return null;
            }
            byte[] in = jedis.get(key.getBytes());
            List<T> list = (List<T>) JedisUtils.deserialize(in);
            return list;
        } catch (Exception e) {
            return new ArrayList<T>();
        } finally {
            jedisPool.returnResource(jedis);
        }
    }

    public void setKeyValue(String key, String value, int ttl) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value);
            jedis.expire(key, ttl);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedisPool.returnResource(jedis);
        }
    }

    /**
     * redis设置过期时间--毫秒
     * @param key
     * @param value
     * @param ttl  毫秒值范围[1-1000]
     */
    public void setKeyValuePexpire (String key, String value, int ttl) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value);
            jedis.pexpire(key, ttl);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedisPool.returnResource(jedis);
        }
    }


    public String getCustIdByToken(String token) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String curCustId = jedis.get(token);
            if (StringUtils.isEmpty(curCustId)) {
                throw new HuhuaminException("token过期，请重新登录");
            }
            return curCustId;
        } finally {
            jedisPool.returnResource(jedis);
        }

    }

    public String getValueByKey(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.get(key);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedisPool.returnResource(jedis);
        }
        return "";
    }

    public void delByKey(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.del(key);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedisPool.returnResource(jedis);
        }

    }

    public void refreshCustToken(String custId, String token) {
        delByKey(getValueByKey(custId));
        delByKey(custId);

        setKeyValue(token, custId);
        setKeyValue(custId, token);

    }


    public String getValueByKeyDb2(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(2);
            return jedis.get(key);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedisPool.returnResource(jedis);
        }
        return "";
    }

    public void setKeyValuePexpireDb2 (String key, String value, int ttl) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(2);
            jedis.set(key, value);
            jedis.pexpire(key, ttl);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedisPool.returnResource(jedis);
        }
    }
}
