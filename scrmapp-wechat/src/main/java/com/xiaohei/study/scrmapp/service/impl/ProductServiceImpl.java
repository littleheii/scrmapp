package com.xiaohei.study.scrmapp.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiaohei.study.scrmapp.api.ProductApi;
import com.xiaohei.study.scrmapp.config.RabbitConfig;
import com.xiaohei.study.scrmapp.constant.ErrorCode;
import com.xiaohei.study.scrmapp.entity.Product;
import com.xiaohei.study.scrmapp.rabbitmq.Sender;
import com.xiaohei.study.scrmapp.redis.ProductRedis;
import com.xiaohei.study.scrmapp.result.DataMessage;
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

    @Autowired
    private Sender sender;

    @Resource
    private HashOperations<String, String, Product> hashOperations;

    @Override
    public DataMessage getProduct(Long productId) {
        DataMessage dataMessage = new DataMessage();
        Product product = productRedis.get(productId);
        if (null == product) {
            product = productApi.findProduct(productId);
            if (null == product) {
                dataMessage.setCode(ErrorCode.FAIL);
                dataMessage.setMsg("产品不存在!");
                return dataMessage;
            }
            productRedis.put(productId, product, -1);
        }


        sender.send("1000");
        sender.direct("20000");

        dataMessage.setCode(ErrorCode.SUCCESS);
        dataMessage.setData(product);

        return dataMessage;
    }
}
