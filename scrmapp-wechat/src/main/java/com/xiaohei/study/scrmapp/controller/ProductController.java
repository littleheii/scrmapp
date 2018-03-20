package com.xiaohei.study.scrmapp.controller;


import com.xiaohei.study.scrmapp.constant.ErrorCode;
import com.xiaohei.study.scrmapp.entity.Product;
import com.xiaohei.study.scrmapp.result.DataMessage;
import com.xiaohei.study.scrmapp.service.ProductService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "获取产品详细信息", notes = "获取产品id来获取产品详细信息")
    @ApiImplicitParam(name = "id", value = "产品ID", required = true, dataType = "long", paramType = "path")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public DataMessage getProduct(@PathVariable("id") Long productId) {
        DataMessage dataMessage = productService.getProduct(productId);
        return dataMessage;
    }

}
