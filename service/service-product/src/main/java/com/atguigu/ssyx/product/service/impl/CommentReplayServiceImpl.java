package com.atguigu.ssyx.product.service.impl;

import com.atguigu.ssyx.model.product.CommentReplay;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.ssyx.product.dao.CommentReplayDao;

import com.atguigu.ssyx.product.service.CommentReplayService;
import org.springframework.stereotype.Service;

/**
 * 产品评价回复表(CommentReplay)表服务实现类
 *
 * @author makejava
 * @since 2024-03-07 13:43:38
 */
@Service("commentReplayService")
public class CommentReplayServiceImpl extends ServiceImpl<CommentReplayDao, CommentReplay> implements CommentReplayService {

}

