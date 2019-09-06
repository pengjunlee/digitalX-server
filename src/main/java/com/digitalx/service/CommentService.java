package com.digitalx.service;

import com.digitalx.domain.CommentGoodsEntity;
import com.digitalx.domain.CommentEntity;

import java.util.List;

/**
 * @author pengjunlee
 * @create 2019-09-03 17:18
 */
public interface CommentService {

    List<CommentGoodsEntity> listCommentGoods();

    List<CommentEntity> listCommentByGoods(String goodsId);
}
