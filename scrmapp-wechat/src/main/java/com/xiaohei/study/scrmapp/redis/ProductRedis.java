package com.xiaohei.study.scrmapp.redis;

import com.xiaohei.study.scrmapp.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class ProductRedis {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Resource
    private HashOperations<String, String, Product> hashOperations;

    private static final String REDIS_KEY = "PRODUCT:REDIS:KEY";


    /**
     * 存入redis中的key
     *
     * @return
     */
    public String getRedisKey() {
        return this.REDIS_KEY;
    }


    /**
     * 添加
     *
     * @param productId key
     * @param product   对象
     * @param expire    过期时间(单位:秒),传入 -1 时表示不设置过期时间
     */
    public void put(Long productId, Product product, long expire) {
        hashOperations.put(getRedisKey(), productId + "", product);
        if (expire != -1) {
            redisTemplate.expire(getRedisKey(), expire, TimeUnit.SECONDS);
        }
    }

    /**
     * 查询
     *
     * @param productId 查询的key
     * @return
     */
    public Product get(Long productId) {
        return hashOperations.get(getRedisKey(), productId + "");
    }

}
