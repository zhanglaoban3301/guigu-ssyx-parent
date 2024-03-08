package com.atguigu.ssyx.product.controller;



import com.atguigu.ssyx.common.result.Result;
import com.atguigu.ssyx.model.product.SkuImage;
import com.atguigu.ssyx.model.product.SkuPoster;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.atguigu.ssyx.product.service.SkuPosterService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 商品海报表(SkuPoster)表控制层
 *
 * @author makejava
 * @since 2024-03-07 13:50:32
 */
@RestController
@RequestMapping("/pro/skuPoster")
public class SkuPosterController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SkuPosterService skuPosterService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param skuPoster 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<SkuPoster> page, SkuPoster skuPoster) {
        return success(this.skuPosterService.page(page, new QueryWrapper<>(skuPoster)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("getBySkuId")
    public Result selectOne(@PathVariable Serializable id) {
        QueryWrapper<SkuPoster> wrapper = new QueryWrapper<>();
        wrapper.eq("sku_id",id);
        return Result.ok(this.skuPosterService.list(wrapper));
    }

    /**
     * 新增数据
     *
     * @param skuPoster 实体对象
     * @return 新增结果
     */
    @PostMapping("insert")
    public Result insert(@RequestBody SkuPoster skuPoster) {
        return Result.ok(this.skuPosterService.save(skuPoster));
    }

    /**
     * 修改数据
     *
     * @param skuPoster 实体对象
     * @return 修改结果
     */
    @PutMapping("update")
    public Result update(@RequestBody SkuPoster skuPoster) {
        return Result.ok(this.skuPosterService.updateById(skuPoster));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping("delete")
    public Result delete(@RequestParam("idList") List<Long> idList) {
        return Result.ok(this.skuPosterService.removeByIds(idList));
    }
}

