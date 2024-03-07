package com.atguigu.ssyx.product.service.impl;

import com.atguigu.ssyx.model.product.Category;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.ssyx.product.dao.CategoryDao;

import com.atguigu.ssyx.product.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * 商品三级分类(Category)表服务实现类
 *
 * @author makejava
 * @since 2024-03-07 13:41:01
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, Category> implements CategoryService {

}

