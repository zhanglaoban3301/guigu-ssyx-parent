package com.atguigu.ssyx.product.service.impl;

import com.atguigu.ssyx.model.product.SkuAttrValue;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.ssyx.product.dao.SkuAttrValueDao;

import com.atguigu.ssyx.product.service.SkuAttrValueService;
import org.springframework.stereotype.Service;

/**
 * spu属性值(SkuAttrValue)表服务实现类
 *
 * @author makejava
 * @since 2024-03-07 13:46:20
 */
@Service("skuAttrValueService")
public class SkuAttrValueServiceImpl extends ServiceImpl<SkuAttrValueDao, SkuAttrValue> implements SkuAttrValueService {

}

