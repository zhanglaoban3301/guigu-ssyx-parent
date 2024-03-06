package com.atguigu.ssyx.service.impl;

import com.atguigu.ssyx.model.sys.Region;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.atguigu.ssyx.service.RegionService;
import com.atguigu.ssyx.mapper.RegionMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
* @author Administrator
* @description 针对表【region(地区表)】的数据库操作Service实现
* @createDate 2024-03-06 14:33:03
*/
@Service
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region>
    implements RegionService{

    @Override
    public List<Map<String, Object>> getRegion() {
        return null;
    }
}




