package com.atguigu.ssyx.product.controller;



import com.atguigu.ssyx.common.result.Result;
import com.atguigu.ssyx.model.product.AttrGroup;
import com.atguigu.ssyx.model.product.Category;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.atguigu.ssyx.product.service.AttrGroupService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 属性分组(AttrGroup)表控制层
 *
 * @author makejava
 * @since 2024-03-07 13:39:27
 */
@RestController
@RequestMapping("pro/attrGroup")
public class AttrGroupController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private AttrGroupService attrGroupService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param attrGroup 查询实体
     * @return 所有数据
     */
    @PostMapping("selectAll")
    public Result selectAll(@RequestBody Map map) {

        Page page1 = new Page(Integer.parseInt(map.get("current").toString()),
                Integer.parseInt(map.get("size").toString()));
        AttrGroup attrGroup = new AttrGroup();
        if(map.get("name") != null && map.get("name") != ""){
            attrGroup.setName((String) map.get("name"));
        }
        if(map.get("sort") != null && map.get("sort") != ""){
            attrGroup.setSort(Integer.parseInt(map.get("sort").toString()));
        }
        return Result.ok(this.attrGroupService.page(page1, new QueryWrapper<>(attrGroup)));
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.attrGroupService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param attrGroup 实体对象
     * @return 新增结果
     */
    @PostMapping("insert")
    public Result insert(@RequestBody AttrGroup attrGroup) {
        return Result.ok(this.attrGroupService.save(attrGroup));
    }

    /**
     * 修改数据
     *
     * @param attrGroup 实体对象
     * @return 修改结果
     */
    @PutMapping("update")
    public Result update(@RequestBody AttrGroup attrGroup) {
        return Result.ok(this.attrGroupService.updateById(attrGroup));
    }

    /**
     * 删除数据
     *
     * @param ids 主键结合
     * @return 删除结果
     */
    @DeleteMapping("delete")
    public Result delete(@RequestBody List<Long> ids) {
        return Result.ok(this.attrGroupService.removeByIds(ids));
    }
}

