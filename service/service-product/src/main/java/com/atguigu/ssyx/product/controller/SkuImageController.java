package com.atguigu.ssyx.product.controller;



import com.atguigu.ssyx.common.result.Result;
import com.atguigu.ssyx.model.product.SkuImage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.atguigu.ssyx.product.service.SkuImageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 商品图片(SkuImage)表控制层
 *
 * @author makejava
 * @since 2024-03-07 13:47:53
 */
@RestController
@RequestMapping("/pro/skuImage")
public class SkuImageController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SkuImageService skuImageService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param skuImage 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<SkuImage> page, SkuImage skuImage) {
        return success(this.skuImageService.page(page, new QueryWrapper<>(skuImage)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("getBySkuId")
    public Result getBySkuId(@RequestParam Long id) {
        QueryWrapper<SkuImage> skuImageQueryWrapper = new QueryWrapper<>();
        skuImageQueryWrapper.eq("sku_id",id);

        return Result.ok(this.skuImageService.list(skuImageQueryWrapper));
    }

    /**
     * 新增数据
     *
     * @param skuImage 实体对象
     * @return 新增结果
     */
    @PostMapping("insert")
    public Result insert(@RequestBody SkuImage skuImage) {
        return Result.ok(this.skuImageService.save(skuImage));
    }

    /**
     * 修改数据
     *
     * @param skuImage 实体对象
     * @return 修改结果
     */
    @PutMapping("update")
    public Result update(@RequestBody SkuImage skuImage) {
        return Result.ok(this.skuImageService.updateById(skuImage));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping("delete")
    public Result delete(@RequestParam("idList") List<Long> idList) {
        return Result.ok(this.skuImageService.removeByIds(idList));
    }
}

