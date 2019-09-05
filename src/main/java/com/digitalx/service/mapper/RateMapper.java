package com.digitalx.service.mapper;

import com.digitalx.domain.MenuEntity;
import com.digitalx.domain.RateGoodsEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author pengjunlee
 * @create 2019-09-03 17:13
 */
@Mapper
public interface RateMapper {

    List<RateGoodsEntity> listRateGoods();
}
