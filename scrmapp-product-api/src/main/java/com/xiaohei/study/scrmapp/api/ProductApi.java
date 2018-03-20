package com.xiaohei.study.scrmapp.api;

import com.xiaohei.study.scrmapp.entity.Product;

public interface ProductApi {

    int saveProduct(Product product);

    Product findProduct(Long id);
}
