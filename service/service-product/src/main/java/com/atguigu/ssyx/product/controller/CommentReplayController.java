package com.atguigu.ssyx.product.controller;



import com.atguigu.ssyx.model.product.CommentReplay;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.atguigu.ssyx.product.service.CommentReplayService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 产品评价回复表(CommentReplay)表控制层
 *
 * @author makejava
 * @since 2024-03-07 13:43:38
 */
@RestController
@RequestMapping("commentReplay")
public class CommentReplayController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private CommentReplayService commentReplayService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param commentReplay 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<CommentReplay> page, CommentReplay commentReplay) {
        return success(this.commentReplayService.page(page, new QueryWrapper<>(commentReplay)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.commentReplayService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param commentReplay 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody CommentReplay commentReplay) {
        return success(this.commentReplayService.save(commentReplay));
    }

    /**
     * 修改数据
     *
     * @param commentReplay 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody CommentReplay commentReplay) {
        return success(this.commentReplayService.updateById(commentReplay));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.commentReplayService.removeByIds(idList));
    }
}

