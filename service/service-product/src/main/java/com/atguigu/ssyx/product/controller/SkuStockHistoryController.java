package com.atguigu.ssyx.product.controller;



import com.atguigu.ssyx.model.product.SkuStockHistory;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.atguigu.ssyx.product.service.SkuStockHistoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * sku的库存历史记录(SkuStockHistory)表控制层
 *
 * @author makejava
 * @since 2024-03-07 13:51:28
 */
@RestController
@RequestMapping("skuStockHistory")
public class SkuStockHistoryController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SkuStockHistoryService skuStockHistoryService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param skuStockHistory 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<SkuStockHistory> page, SkuStockHistory skuStockHistory) {
        return success(this.skuStockHistoryService.page(page, new QueryWrapper<>(skuStockHistory)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.skuStockHistoryService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param skuStockHistory 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody SkuStockHistory skuStockHistory) {
        return success(this.skuStockHistoryService.save(skuStockHistory));
    }

    /**
     * 修改数据
     *
     * @param skuStockHistory 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody SkuStockHistory skuStockHistory) {
        return success(this.skuStockHistoryService.updateById(skuStockHistory));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.skuStockHistoryService.removeByIds(idList));
    }
}

