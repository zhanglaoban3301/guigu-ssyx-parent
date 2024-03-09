package com.atguigu.ssyx.product.service.impl;

import com.atguigu.ssyx.model.product.SkuStockHistory;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.ssyx.product.dao.SkuStockHistoryDao;

import com.atguigu.ssyx.product.service.SkuStockHistoryService;
import org.springframework.stereotype.Service;

/**
 * sku的库存历史记录(SkuStockHistory)表服务实现类
 *
 * @author makejava
 * @since 2024-03-07 13:51:28
 */
@Service("skuStockHistoryService")
public class SkuStockHistoryServiceImpl extends ServiceImpl<SkuStockHistoryDao, SkuStockHistory> implements SkuStockHistoryService {

}

