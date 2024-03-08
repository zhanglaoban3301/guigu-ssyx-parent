package com.atguigu.ssyx.product.controller;

import com.atguigu.ssyx.common.result.Result;
import com.atguigu.ssyx.model.product.Attr;
import com.atguigu.ssyx.model.product.AttrGroup;
import com.atguigu.ssyx.vo.product.CommonPageSearch;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.atguigu.ssyx.product.service.AttrService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 商品属性(Attr)表控制层
 *
 * @author makejava
 * @since 2024-03-07 13:32:54
 */
@RestController
@RequestMapping("pro/attr")
public class AttrController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private AttrService attrService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param attr 查询实体
     * @return 所有数据
     */

    @PostMapping("selectAll")
    public Result selectAll(@RequestBody CommonPageSearch<Attr> attrSearch) {
        Page page1 = attrSearch.getPage();
        Attr attr = attrSearch.getData();
        return Result.ok(this.attrService.page(page1, new QueryWrapper<>(attr)));
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("getByAttrGroupId")
    public Result getByAttrGroupId(@RequestParam("id") Long id) {
        QueryWrapper<Attr> attrQueryWrapper = new QueryWrapper<>();
        attrQueryWrapper.eq("attr_group_id",id);
        return Result.ok(this.attrService.list(attrQueryWrapper));
    }

    /**
     * 新增数据
     *
     * @param attr 实体对象
     * @return 新增结果
     */
    @PostMapping("insert")
    public Result insert(@RequestBody Attr attr) {
        return Result.ok(this.attrService.save(attr));
    }

    /**
     * 修改数据
     *
     * @param attr 实体对象
     * @return 修改结果
     */
    @PutMapping("update")
    public Result update(@RequestBody Attr attr) {
        return Result.ok(this.attrService.updateById(attr));
    }

    /**
     * 删除数据
     *
     * @param ids 主键结合
     * @return 删除结果
     */
    @DeleteMapping("delete")
    public Result delete(@RequestBody List<Long> ids) {
        return Result.ok(this.attrService.removeByIds(ids));
    }
}

