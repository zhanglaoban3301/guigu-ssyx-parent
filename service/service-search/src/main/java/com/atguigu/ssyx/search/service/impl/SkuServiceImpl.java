package com.atguigu.ssyx.search.service.impl;

import com.atguigu.ssyx.search.repository.SkuRepository;
import com.atguigu.ssyx.search.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkuServiceImpl implements SkuService {
    @Autowired
    private SkuRepository skuRepository;
    @Override
    public void upperSku(Long skuId) {
        //通过远程调用获取skuid相关信息

        //封装成对象

        //添加到es
    }

    @Override
    public void lowerSku(Long skuId) {
        skuRepository.deleteById(skuId);
    }
}
