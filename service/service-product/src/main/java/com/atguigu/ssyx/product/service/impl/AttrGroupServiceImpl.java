package com.atguigu.ssyx.product.service.impl;

import com.atguigu.ssyx.model.product.AttrGroup;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.ssyx.product.dao.AttrGroupDao;

import com.atguigu.ssyx.product.service.AttrGroupService;
import org.springframework.stereotype.Service;

/**
 * 属性分组(AttrGroup)表服务实现类
 *
 * @author makejava
 * @since 2024-03-07 13:39:28
 */
@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroup> implements AttrGroupService {

}

