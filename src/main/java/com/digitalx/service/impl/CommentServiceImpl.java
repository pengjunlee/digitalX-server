package com.digitalx.service.impl;

import com.digitalx.domain.*;
import com.digitalx.service.CommentService;
import com.digitalx.service.mapper.CommentMapper;
import com.digitalx.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pengjunlee
 * @create 2019-09-03 17:19
 */
@Service("CommentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper CommentMapper;

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public PageUtil pageCommentGoods(int page) {
        Integer limit = 100;
        Integer offset = (page - 1) * limit;
        List<CommentGoodsEntity> commentGoodsEntities = CommentMapper.pageCommentGoods(offset, limit);
        int count = CommentMapper.countCommentGoods();
        return new PageUtil(commentGoodsEntities, count);
    }


    @Override
    public List<CommentEntity> listCommentByGoods(String goodsId) {
        Query query = new Query(Criteria.where("goodsId").is(Long.parseLong(goodsId)));
        List<CommentEntity> tmallCommentEntities = mongoTemplate.find(query, CommentEntity.class, "tmallRateEntity");
        return tmallCommentEntities;
    }

    @Override
    public PageUtil pageCommentByGoods(String goodsId, int page) {
        int offset = (page - 1) * 100;
        Query query = new Query(Criteria.where("goodsId").is(Long.parseLong(goodsId)));
        // 获取数据条数
        int count = mongoTemplate.find(query, CommentEntity.class, "tmallRateEntity").size();
        // 获取数据内容
        query.with(new Sort(Sort.Direction.valueOf("DESC"), "rateDate"));
        query.skip(offset);
        query.limit(100);
        List<CommentEntity> tmallCommentEntities = mongoTemplate.find(query, CommentEntity.class, "tmallRateEntity");
        return new PageUtil(tmallCommentEntities, count);
    }
}
