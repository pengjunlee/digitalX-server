package com.digitalx;

import com.digitalx.service.CommentService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pengjunlee
 * @create 2019-09-03 18:16
 */

// @RunWith(SpringRunner.class)
public class DigitalxTest {

//    @Autowired
//    private CommentService commentService;
//
//    @Test
//    public void testPassword() {
//        SimpleHash sh = new SimpleHash("SHA-1", "123456", "graython", 16);
//        System.out.println(sh.toString());
//    }
//
//    @Test
//    public void testSpliter() {
//        commentService.listCommentByGoods("18539499729");
//    }

    @Test
    public void testSublist() {
        List<String> list = new ArrayList<>();

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        list = list.subList(0,2);
        List<String> new_list=new ArrayList<>(list);
        System.out.println(new_list.getClass());
    }
}