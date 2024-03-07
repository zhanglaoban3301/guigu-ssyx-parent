package com.atguigu.ssyx.service;


import com.atguigu.ssyx.model.sys.RegionWare;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Update;

/**
* @author Administrator
* @description 针对表【region_ware(城市仓库关联表)】的数据库操作Service
* @createDate 2024-03-06 14:33:15
*/
public interface RegionWareService extends IService<RegionWare> {
    void updateStatus(int status,Long id);
}
