package com.atguigu.ssyx.product.service.impl;

import com.atguigu.ssyx.model.product.SkuImage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.ssyx.product.dao.SkuImageDao;

import com.atguigu.ssyx.product.service.SkuImageService;
import org.springframework.stereotype.Service;

/**
 * 商品图片(SkuImage)表服务实现类
 *
 * @author makejava
 * @since 2024-03-07 13:47:53
 */
@Service("skuImageService")
public class SkuImageServiceImpl extends ServiceImpl<SkuImageDao, SkuImage> implements SkuImageService {

}

