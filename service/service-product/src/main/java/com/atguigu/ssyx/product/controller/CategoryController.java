package com.atguigu.ssyx.product.controller;



import com.atguigu.ssyx.common.result.Result;
import com.atguigu.ssyx.model.product.Category;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.atguigu.ssyx.product.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 商品三级分类(Category)表控制层
 *
 * @author makejava
 * @since 2024-03-07 13:41:01
 */
@RestController
@RequestMapping("pro/category")
public class CategoryController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private CategoryService categoryService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param category 查询实体
     * @return 所有数据
     */
    @PostMapping ("selectAll")
    public Result selectAll(@RequestBody Map map) {

        Page page1 = new Page(Integer.parseInt(map.get("current").toString()),
                Integer.parseInt(map.get("size").toString()));
        Category category = new Category();
        if(map.get("name") != null && map.get("name") != ""){
            category.setName((String) map.get("name"));
        }
        if(map.get("sort") != null && map.get("sort") != ""){
            category.setSort(Integer.parseInt(map.get("sort").toString()));
        }
        return Result.ok(this.categoryService.page(page1, new QueryWrapper<>(category)));
    }

    @GetMapping("count")
    public Result count(){
        return Result.ok(categoryService.count());
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("find")
    public Result selectOne(@RequestParam Long id) {
        return Result.ok(this.categoryService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param category 实体对象
     * @return 新增结果
     */
    @PostMapping("add")
    public Result insert(@RequestBody Category category) {
        return Result.ok(this.categoryService.save(category));
    }

    /**
     * 修改数据
     *
     * @param category 实体对象
     * @return 修改结果
     */
    @PutMapping("update")
    public Result update(@RequestBody Category category) {
        return Result.ok(this.categoryService.updateById(category));
    }

    /**
     * 删除数据
     *
     * @param ids 主键结合
     * @return 删除结果
     */
    @DeleteMapping("delete")
    public Result delete(@RequestBody List<Long> ids) {
        return Result.ok(this.categoryService.removeByIds(ids));
    }
}

