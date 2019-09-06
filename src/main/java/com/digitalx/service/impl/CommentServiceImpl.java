package com.digitalx.service.impl;

import com.digitalx.domain.*;
import com.digitalx.service.CommentService;
import com.digitalx.service.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<CommentGoodsEntity> listCommentGoods() {
        return CommentMapper.listCommentGoods();
    }

    @Override
    public List<CommentEntity> listCommentByGoods(String goodsId) {
        Query query=new Query(Criteria.where("goodsId").is(Long.parseLong(goodsId)));
        List<CommentEntity> tmallCommentEntities = mongoTemplate.find(query, CommentEntity.class, "tmallRateEntity");
        return tmallCommentEntities;
    }
}
