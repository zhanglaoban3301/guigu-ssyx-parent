package com.atguigu.ssyx.product.controller;



import com.atguigu.ssyx.common.result.Result;
import com.atguigu.ssyx.model.product.SkuInfo;
import com.atguigu.ssyx.vo.product.CommonPageSearch;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.atguigu.ssyx.product.service.SkuInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * sku信息(SkuInfo)表控制层
 *
 * @author makejava
 * @since 2024-03-07 13:49:19
 */
@RestController
@RequestMapping("/pro/skuInfo")
public class SkuInfoController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SkuInfoService skuInfoService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param skuInfo 查询实体
     * @return 所有数据
     */
    @PostMapping("selectAll")
    public Result selectAll(@RequestBody CommonPageSearch<SkuInfo> skuInfo) {

        return Result.ok(this.skuInfoService.page(skuInfo.getPage(), new QueryWrapper<>(skuInfo.getData())));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.skuInfoService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param skuInfo 实体对象
     * @return 新增结果
     */
    @PostMapping("insert")
    public Result insert(@RequestBody SkuInfo skuInfo) {
        return Result.ok(this.skuInfoService.save(skuInfo));
    }

    /**
     * 修改数据
     *
     * @param skuInfo 实体对象
     * @return 修改结果
     */
    @PutMapping("update")
    public Result update(@RequestBody SkuInfo skuInfo) {
        return Result.ok(this.skuInfoService.updateById(skuInfo));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping("delete")
    public Result delete(@RequestParam("idList") List<Long> idList) {
        return Result.ok(this.skuInfoService.removeByIds(idList));
    }
}

