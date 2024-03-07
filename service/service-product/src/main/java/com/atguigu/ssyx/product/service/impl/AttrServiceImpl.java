package com.atguigu.ssyx.product.service.impl;

import com.atguigu.ssyx.model.product.Attr;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.ssyx.product.dao.AttrDao;

import com.atguigu.ssyx.product.service.AttrService;
import org.springframework.stereotype.Service;

/**
 * 商品属性(Attr)表服务实现类
 *
 * @author makejava
 * @since 2024-03-07 13:32:55
 */
@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, Attr> implements AttrService {

}

