package com.atguigu.ssyx.service.impl;

import com.atguigu.ssyx.model.sys.RegionWare;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.atguigu.ssyx.service.RegionWareService;
import com.atguigu.ssyx.mapper.RegionWareMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【region_ware(城市仓库关联表)】的数据库操作Service实现
* @createDate 2024-03-06 14:33:15
*/
@Service
public class RegionWareServiceImpl extends ServiceImpl<RegionWareMapper, RegionWare>
    implements RegionWareService{
    @Autowired
    private RegionWareMapper regionWareMapper;
    @Override
    public void updateStatus(int status, Long id) {
        regionWareMapper.updateStatus(status, id);
    }
}




