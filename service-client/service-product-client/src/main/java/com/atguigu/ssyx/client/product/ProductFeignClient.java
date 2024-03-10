package com.atguigu.ssyx.client.product;

import com.atguigu.ssyx.model.product.Category;
import com.atguigu.ssyx.model.product.SkuInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-product")
public interface ProductFeignClient {
    @GetMapping("/api/product/innder/getCategory/{categoryId}")
    Category getCategory(@PathVariable Long categoryId);

    @GetMapping("/api/product/innder/getSkuInfo/{skuId}")
    SkuInfo getSkuInfo(@PathVariable Long skuId);
}
