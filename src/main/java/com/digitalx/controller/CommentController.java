package com.digitalx.controller;

import com.digitalx.domain.BaseResponse;
import com.digitalx.domain.CommentEntity;
import com.digitalx.domain.CommentGoodsEntity;
import com.digitalx.domain.Keyword;
import com.digitalx.service.CommentService;
import com.digitalx.utils.RedisUtil;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;
import org.apdplat.word.segmentation.WordRefiner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author pengjunlee
 * @create 2019-09-04 11:00
 */
@RequestMapping("/api/v1/comment")
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private RedisUtil redisUtil;

    private static final String KEYWORD_PREFIX = "KEYWORD_";


    @GetMapping(value = "/goods/list")
    public Object listGoods() {
        List<CommentGoodsEntity> goodsList = commentService.listCommentGoods();
        BaseResponse<Object> ret = new BaseResponse<Object>();

        Map<String, Object> data = new HashMap<>();
        data.put("goods", goodsList);
        ret.setData(data);
        ret.setCode(0);
        ret.setMsg("数据加载成功");
        return ret;
    }

    @GetMapping(value = "/list/{goodsId}")
    public Object lisComments(@PathVariable(name = "goodsId") String goodsId) {
        List<CommentEntity> CommentsList = commentService.listCommentByGoods(goodsId);
        BaseResponse<Object> ret = new BaseResponse<Object>();

        Map<String, Object> data = new HashMap<>();
        data.put("comments", CommentsList);
        ret.setData(data);
        ret.setCode(0);
        ret.setMsg("数据加载成功");
        return ret;
    }


    @GetMapping(value = "/keyword/{goodsId}")
    public Object lisKeywords(@PathVariable(name = "goodsId") String goodsId) {

        String key = KEYWORD_PREFIX + goodsId;


        List<Keyword> values = null;
        if (redisUtil.hasKey(key)) {
            Object o = redisUtil.get(key);
            if (o != null) {
                values = (List<Keyword>) o;
            }
        } else {
            List<CommentEntity> CommentsList = commentService.listCommentByGoods(goodsId);
            List<Word> words = null;
            Map<String, Keyword> map = new HashMap<String, Keyword>();
            for (CommentEntity comment : CommentsList) {
                words = WordSegmenter.seg(comment.getRateContent());
                words = WordRefiner.refine(words);
                for (Word word : words) {
                    Keyword keyword = map.get(word.getText());
                    if (keyword == null) {
                        keyword = new Keyword(word.getText());
                    } else {
                        keyword.addWeight(1);
                    }
                    map.put(word.getText(), keyword);
                }
            }
            List<Keyword> list = new ArrayList<>(map.values());
            Collections.sort(list);
            if (list.size() > 100) {
                values = new ArrayList<Keyword>(list.subList(0, 100));
            }
            redisUtil.set(key, values);
        }
        BaseResponse<Object> ret = new BaseResponse<Object>();

        Map<String, Object> data = new HashMap<>();
        data.put("keywords", values);
        ret.setData(data);
        ret.setCode(0);
        ret.setMsg("数据加载成功");
        return ret;
    }
}
