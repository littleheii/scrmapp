package com.xiaohei.study.scrmapp.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiaohei.study.scrmapp.api.ProductApi;
import com.xiaohei.study.scrmapp.entity.Product;
import com.xiaohei.study.scrmapp.redis.ProductRedis;
import com.xiaohei.study.scrmapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductServiceImpl implements ProductService {

    @Reference
    private ProductApi productApi;

    @Autowired
    private ProductRedis productRedis;

    @Resource
    private HashOperations<String, String, Product> hashOperations;

    @Override
    public Product getProduct(Long productId) {
        Product product = productRedis.get(productId);
        if (null != product) {
            return product;
        }
        product = productApi.findProduct(productId);
        productRedis.put(productId, product, -1);
        return product;
    }
}
