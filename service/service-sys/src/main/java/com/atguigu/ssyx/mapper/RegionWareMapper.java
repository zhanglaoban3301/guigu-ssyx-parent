package com.atguigu.ssyx.mapper;


import com.atguigu.ssyx.model.sys.RegionWare;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
* @author Administrator
* @description 针对表【region_ware(城市仓库关联表)】的数据库操作Mapper
* @createDate 2024-03-06 14:33:15
* @Entity generator.domain.RegionWare
*/
@Mapper
public interface RegionWareMapper extends BaseMapper<RegionWare> {
    @Select("select * from region_ware where is_deleted = '0' limit #{pageNo} , #{pageSize} ")
    List<RegionWare> getRegionList(int pageNo,int pageSize);
    @Update("update region_ware set status= #{status} where id = #{id} ")
    void updateStatus(int status,Long id);
}




