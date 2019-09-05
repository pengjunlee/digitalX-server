package com.digitalx.service.impl;

import com.digitalx.domain.MenuEntity;
import com.digitalx.domain.RateGoodsEntity;
import com.digitalx.domain.UserAuthInfo;
import com.digitalx.domain.UserEntity;
import com.digitalx.service.RateService;
import com.digitalx.service.UserService;
import com.digitalx.service.mapper.MenuMapper;
import com.digitalx.service.mapper.RateMapper;
import com.digitalx.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pengjunlee
 * @create 2019-09-03 17:19
 */
@Service("rateService")
public class RateServiceImpl implements RateService {

    @Autowired
    private RateMapper rateMapper;


    @Override
    public List<RateGoodsEntity> listRateGoods() {
        return rateMapper.listRateGoods();
    }
}
