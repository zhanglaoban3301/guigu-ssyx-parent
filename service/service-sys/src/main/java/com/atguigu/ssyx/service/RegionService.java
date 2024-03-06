package com.atguigu.ssyx.service;


import com.atguigu.ssyx.model.sys.Region;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
* @author Administrator
* @description 针对表【region(地区表)】的数据库操作Service
* @createDate 2024-03-06 14:33:03
*/
public interface RegionService extends IService<Region> {
    List<Map<String,Object>> getRegion();
}
