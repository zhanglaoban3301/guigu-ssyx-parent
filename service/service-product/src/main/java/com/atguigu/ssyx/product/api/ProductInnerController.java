package com.atguigu.ssyx.product.api;

import com.atguigu.ssyx.model.product.Category;
import com.atguigu.ssyx.model.product.SkuInfo;
import com.atguigu.ssyx.product.service.CategoryService;
import com.atguigu.ssyx.product.service.SkuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductInnerController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SkuInfoService skuInfoService;
    //根据skuid获取分类信息
    @GetMapping("innder/getCategory/{categoryId}")
    public Category getCategory(@PathVariable Long categoryId){
        Category byId = categoryService.getById(categoryId);
        return byId;
    }
    //根据skuid获取sku信息
    @GetMapping("innder/getSkuInfo/{skuId}")
    public SkuInfo getSkuInfo(@PathVariable Long skuId){
        return skuInfoService.getById(skuId);
    }
}
