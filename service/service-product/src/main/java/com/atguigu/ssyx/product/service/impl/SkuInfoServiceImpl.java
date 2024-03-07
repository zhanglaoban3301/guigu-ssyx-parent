package com.atguigu.ssyx.product.service.impl;

import com.atguigu.ssyx.model.product.SkuInfo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.ssyx.product.dao.SkuInfoDao;

import com.atguigu.ssyx.product.service.SkuInfoService;
import org.springframework.stereotype.Service;

/**
 * sku信息(SkuInfo)表服务实现类
 *
 * @author makejava
 * @since 2024-03-07 13:49:19
 */
@Service("skuInfoService")
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoDao, SkuInfo> implements SkuInfoService {

}

