package com.atguigu.ssyx.service.impl;

import com.atguigu.ssyx.mapper.RegionWareMapper;
import com.atguigu.ssyx.mapper.WareMapper;
import com.atguigu.ssyx.model.sys.Region;
import com.atguigu.ssyx.model.sys.RegionWare;
import com.atguigu.ssyx.model.sys.Ware;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.atguigu.ssyx.service.RegionService;
import com.atguigu.ssyx.mapper.RegionMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private RegionWareMapper regionWareMapper;
    @Autowired
    private RegionMapper regionMapper;
    @Autowired
    private WareMapper wareMapper;
    @Override
    public List<RegionWare> getRegion(int pageNo, int pageSize) {
        return regionWareMapper.getRegionList((pageNo - 1) * pageSize,pageNo * pageSize);
    }

    @Override
    public void addRegion(RegionWare regionWare) {
        Long regionId = regionWare.getRegionId();
        Region region = regionMapper.selectById(regionId);
        String regionName = region.getName();
        Ware ware = new Ware();
        ware.setCity(regionName);
        ware.setProvince(regionName);
        ware.setName(regionWare.getWareName());
        wareMapper.insert(ware);
        Long wareId = ware.getId();
        RegionWare regionWare1 = new RegionWare();
        regionWare1.setRegionId(regionId);
        regionWare1.setRegionName(regionName);
        regionWare1.setWareId(wareId);
        regionWare1.setWareName(regionWare.getWareName());
        regionWare1.setStatus(1);
        regionWareMapper.insert(regionWare1);
    }
}




