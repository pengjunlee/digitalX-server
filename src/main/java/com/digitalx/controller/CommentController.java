package com.digitalx.controller;

import com.digitalx.domain.BaseResponse;
import com.digitalx.domain.CommentGoodsEntity;
import com.digitalx.domain.CommentEntity;
import com.digitalx.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pengjunlee
 * @create 2019-09-04 11:00
 */
@RequestMapping("/api/v1/comment")
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;


    @GetMapping(value = "/goods/list")
    public Object listGoods(){
        List<CommentGoodsEntity> goodsList = commentService.listCommentGoods();
        BaseResponse<Object> ret = new BaseResponse<Object>();

        Map<String,Object> data = new HashMap<>();
        data.put("goods",goodsList);
        ret.setData(data);
        ret.setCode(0);
        ret.setMsg("数据加载成功");
        return ret;
    }

    @GetMapping(value = "/list/{goodsId}")
    public Object lisComments(@PathVariable(name = "goodsId") String goodsId){
        System.out.println("请求评论数据");
        List<CommentEntity> CommentsList = commentService.listCommentByGoods(goodsId);
        BaseResponse<Object> ret = new BaseResponse<Object>();

        Map<String,Object> data = new HashMap<>();
        data.put("comments",CommentsList);
        ret.setData(data);
        ret.setCode(0);
        ret.setMsg("数据加载成功");
        return ret;
    }
}
