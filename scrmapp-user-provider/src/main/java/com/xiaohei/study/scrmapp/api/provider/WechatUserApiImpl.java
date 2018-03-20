package com.xiaohei.study.scrmapp.api.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaohei.study.scrmapp.api.WechatUserApi;
import com.xiaohei.study.scrmapp.entity.WechatUser;
import com.xiaohei.study.scrmapp.mapper.WechatUserMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class WechatUserApiImpl implements WechatUserApi {

    @Autowired
    private WechatUserMapper wechatUserMapper;

    @Override
    public int saveWechatUser(WechatUser wechatUser) {
        return wechatUserMapper.save(wechatUser);
    }
}
