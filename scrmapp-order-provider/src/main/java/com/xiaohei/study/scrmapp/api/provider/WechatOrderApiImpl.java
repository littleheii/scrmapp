package com.xiaohei.study.scrmapp.api.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaohei.study.scrmapp.api.WechatOrderApi;
import com.xiaohei.study.scrmapp.entity.WechatOrder;
import com.xiaohei.study.scrmapp.mapper.WechatOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class WechatOrderApiImpl implements WechatOrderApi {

    @Autowired
    private WechatOrderMapper wechatOrderMapper;

    @Override
    public int saveWechatOrder(WechatOrder wechatOrders) {
        return wechatOrderMapper.save(wechatOrders);
    }
}
