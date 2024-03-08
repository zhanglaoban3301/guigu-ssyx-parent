package com.atguigu.ssyx.product.controller;



import com.atguigu.ssyx.common.result.Result;
import com.atguigu.ssyx.model.product.SkuAttrValue;
import com.atguigu.ssyx.vo.product.CommonPageSearch;
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
@RequestMapping("/pro/skuAttrValue")
public class SkuAttrValueController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SkuAttrValueService skuAttrValueService;



    /**
     * 通过主键查询单条数据
     *
     * @param skuId 主键
     * @return 单条数据
     */
    @GetMapping("getBySkuId")
    public Result getBySkuId(@RequestParam("skuId") Long skuId) {
        QueryWrapper<SkuAttrValue> wrapper = new QueryWrapper<>();
        wrapper.eq("sku_id",skuId);
        return Result.ok(this.skuAttrValueService.list(wrapper));
    }

    /**
     * 新增数据
     *
     * @param skuAttrValue 实体对象
     * @return 新增结果
     */
    @PostMapping("insert")
    public Result insert(@RequestBody SkuAttrValue skuAttrValue) {
        return Result.ok(this.skuAttrValueService.save(skuAttrValue));
    }

    /**
     * 修改数据
     *
     * @param skuAttrValue 实体对象
     * @return 修改结果
     */
    @PutMapping("update")
    public Result update(@RequestBody SkuAttrValue skuAttrValue) {
        return Result.ok(this.skuAttrValueService.updateById(skuAttrValue));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping("delete")
    public Result delete(@RequestParam("idList") List<Long> idList) {
        return Result.ok(this.skuAttrValueService.removeByIds(idList));
    }
}

