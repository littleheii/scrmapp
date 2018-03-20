package com.xiaohei.study.scrmapp.api.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaohei.study.scrmapp.api.ProductApi;
import com.xiaohei.study.scrmapp.entity.Product;
import com.xiaohei.study.scrmapp.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProductApiImpl implements ProductApi {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public int saveProduct(Product product) {
        return productMapper.save(product);
    }

    @Override
    public Product findProduct(Long id) {
        return productMapper.findById(id);
    }
}
