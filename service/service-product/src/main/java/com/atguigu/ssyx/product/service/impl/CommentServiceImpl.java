package com.atguigu.ssyx.product.service.impl;

import com.atguigu.ssyx.model.product.Comment;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.ssyx.product.dao.CommentDao;

import com.atguigu.ssyx.product.service.CommentService;
import org.springframework.stereotype.Service;

/**
 * 商品评价(Comment)表服务实现类
 *
 * @author makejava
 * @since 2024-03-07 13:42:17
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentDao, Comment> implements CommentService {

}

