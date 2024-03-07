package com.atguigu.ssyx.product.controller;



import com.atguigu.ssyx.model.product.SkuAttrValue;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.atguigu.ssyx.product.service.SkuAttrValueService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * spu属性值(SkuAttrValue)表控制层
 *
 * @author makejava
 * @since 2024-03-07 13:46:20
 */
@RestController
@RequestMapping("skuAttrValue")
public class SkuAttrValueController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SkuAttrValueService skuAttrValueService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param skuAttrValue 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<SkuAttrValue> page, SkuAttrValue skuAttrValue) {
        return success(this.skuAttrValueService.page(page, new QueryWrapper<>(skuAttrValue)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.skuAttrValueService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param skuAttrValue 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody SkuAttrValue skuAttrValue) {
        return success(this.skuAttrValueService.save(skuAttrValue));
    }

    /**
     * 修改数据
     *
     * @param skuAttrValue 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody SkuAttrValue skuAttrValue) {
        return success(this.skuAttrValueService.updateById(skuAttrValue));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.skuAttrValueService.removeByIds(idList));
    }
}

