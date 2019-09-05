package com.digitalx;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

/**
 * @author pengjunlee
 * @create 2019-09-03 18:16
 */
public class DigitalxTest {
    @Test
    public void testPassword(){
        SimpleHash sh=new SimpleHash("SHA-1","123456", "graython", 16);
        System.out.println(sh.toString());
    }
}
