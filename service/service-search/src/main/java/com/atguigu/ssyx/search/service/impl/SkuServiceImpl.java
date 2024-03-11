package com.atguigu.ssyx.search.service.impl;

import com.atguigu.ssyx.client.product.ProductFeignClient;
import com.atguigu.ssyx.enums.SkuType;
import com.atguigu.ssyx.model.product.Category;
import com.atguigu.ssyx.model.product.SkuInfo;
import com.atguigu.ssyx.model.search.SkuEs;
import com.atguigu.ssyx.search.repository.SkuRepository;
import com.atguigu.ssyx.search.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkuServiceImpl implements SkuService {
    @Autowired
    private SkuRepository skuRepository;
    @Autowired
    private ProductFeignClient productFeignClient;
    @Override
    public void upperSku(Long skuId) {
        //通过远程调用获取skuid相关信息
        SkuInfo skuInfo = productFeignClient.getSkuInfo(skuId);
        if(skuInfo == null){
            return;
        }
        Category category = productFeignClient.getCategory(skuInfo.getCategoryId());
        //封装成对象
        SkuEs skuEs = new SkuEs();
        if(category != null){
            skuEs.setCategoryId(category.getId());
            skuEs.setCategoryName(category.getName());
        }
        skuEs.setId(skuInfo.getId());
        skuEs.setKeyword(skuInfo.getSkuName()+","+skuEs.getCategoryName());
        skuEs.setWareId(skuInfo.getWareId());
        skuEs.setIsNewPerson(skuInfo.getIsNewPerson());
        skuEs.setImgUrl(skuInfo.getImgUrl());
        skuEs.setTitle(skuInfo.getSkuName());
        if(skuInfo.getSkuType() == SkuType.COMMON.getCode()){
            skuEs.setSkuType(0);
            skuEs.setPrice(skuInfo.getPrice().doubleValue());
            skuEs.setStock(skuInfo.getSale());
            skuEs.setPerLimit(skuInfo.getPerLimit());
        }else{
            //TODO 待完善
        }
        SkuEs save = skuRepository.save(skuEs);
        //添加到es
    }

    @Override
    public void lowerSku(Long skuId) {
        skuRepository.deleteById(skuId);
    }
}
