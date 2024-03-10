package com.atguigu.ssyx.search.service;

import org.springframework.stereotype.Service;


public interface SkuService {
    void upperSku(Long skuId);
    void lowerSku(Long skuId);
}
