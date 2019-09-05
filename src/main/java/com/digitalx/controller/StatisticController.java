package com.digitalx.controller;

import com.digitalx.domain.BaseResponse;
import com.digitalx.domain.RateGoodsEntity;
import com.digitalx.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pengjunlee
 * @create 2019-09-04 11:00
 */
@RequestMapping("/api")
@RestController
public class StatisticController {

    @Autowired
    private RateService rateService;
    @GetMapping(value = "/rate/goods")
    public Object listGoods(){
        List<RateGoodsEntity> goodsList = rateService.listRateGoods();
        BaseResponse<Object> ret = new BaseResponse<Object>();

        Map<String,Object> data = new HashMap<>();
        data.put("goods",goodsList);
        ret.setData(data);
        ret.setCode(0);
        ret.setMsg("数据加载成功");
        return ret;
    }
}
