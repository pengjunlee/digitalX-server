package com.digitalx;

import com.digitalx.domain.Keyword;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.SegmentationAlgorithm;
import org.apdplat.word.segmentation.Word;
import org.apdplat.word.segmentation.WordRefiner;
import org.junit.Test;

import java.util.*;

/**
 * @author pengjunlee
 * @create 2019-09-03 18:16
 */
public class WordSpliterTest {
    @Test
    public void testPassword(){
        // List<Word> words = WordSegmenter.seg("杨尚川是APDPlat应用级产品开发平台的作者");
        List<Word> words = WordSegmenter.segWithStopWords("杨尚川是APDPlat应用级产品开发平台的作者");

        System.out.println(words);
    }

//    SegmentationAlgorithm的可选类型为：
//    正向最大匹配算法：MaximumMatching
//    逆向最大匹配算法：ReverseMaximumMatching
//    正向最小匹配算法：MinimumMatching
//    逆向最小匹配算法：ReverseMinimumMatching
//    双向最大匹配算法：BidirectionalMaximumMatching
//    双向最小匹配算法：BidirectionalMinimumMatching
//    双向最大最小匹配算法：BidirectionalMaximumMinimumMatching
//    全切分算法：FullSegmentation
//    最少分词算法：MinimalWordCount
//    最大Ngram分值算法：MaxNgramScore
    @Test
    public void testConfig(){
        List<Word> words = WordSegmenter.seg("好好好好好好全棉时代这个洗脸巾好还是非常好用的，嗯，已经连续用了好些时间嗯，首先没有白色的那个絮状，掉下来也比较干净清爽，用过的也还可以用来擦拭柜台或者擦血，这样的我觉得还是比较实惠，活动价买的，可以用好几个月了，整体来说非常不错", SegmentationAlgorithm.BidirectionalMaximumMatching);
        // List<Word> words = WordSegmenter.segWithStopWords("全棉时代这个洗脸巾还是非常好用的全棉时代这个洗脸巾还是非常好用的，嗯，已经连续用了好些时间嗯，首先没有白色的那个絮状，掉下来也比较干净清爽，用过的也还可以用来擦拭柜台或者擦血，这样的我觉得还是比较实惠，活动价买的，可以用好几个月了，整体来说非常不错");
        words = WordRefiner.refine(words);

        Map<String,Keyword> map=new HashMap<String,Keyword>();
        for (Word word: words){
            Keyword keyword=map.get(word.getText());
            if(keyword==null){
                keyword= new Keyword(word.getText());
            }else{
                keyword.addWeight(1);
            }
            map.put(word.getText(),keyword);
        }
        List<Keyword> values = new ArrayList<>(map.values());
        Collections.sort(values);
        for(Keyword a: values){
            System.out.println(a);
        }
    }
}
