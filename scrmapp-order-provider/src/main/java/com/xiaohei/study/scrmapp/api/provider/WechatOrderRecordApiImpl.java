package com.xiaohei.study.scrmapp.api.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaohei.study.scrmapp.api.WechatOrderRecordApi;
import com.xiaohei.study.scrmapp.entity.WechatOrderRecord;
import com.xiaohei.study.scrmapp.mapper.WechatOrderRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class WechatOrderRecordApiImpl implements WechatOrderRecordApi {

    @Autowired
    WechatOrderRecordMapper wechatOrderRecordMapper;


    @Override
    public int saveWechatOrderRecord(WechatOrderRecord wechatOrderRecord) {
        return wechatOrderRecordMapper.save(wechatOrderRecord);
    }
}
