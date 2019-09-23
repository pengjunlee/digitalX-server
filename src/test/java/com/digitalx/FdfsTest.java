package com.digitalx;

import com.digitalx.utils.FdfsUtil;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author pengjunlee
 * @create 2019-09-17 16:33
 */
public class FdfsTest {
    /**
     * 文件上传测试
     */
    // @Test
    public void testUpload() {
        File file = new File("C:\\1.jpg");
        try {
            String fdfsPath = FdfsUtil.upload(file);
            System.out.println("文件上传成功，文件ID： " + fdfsPath); // 文件ID： group1/M00/00/00/rBD67l2BM0mEP2WXAAAAABISex8406.jpg
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 文件下载测试
     */
    // @Test
    public void testDownload() throws FileNotFoundException {
        try {
            long downloadSize = FdfsUtil.download(new FileOutputStream(new File("C:\\1_bak.jpg")), "group1/M00/00/00/rBD67l2BM0mEP2WXAAAAABISex8406.jpg");
            System.out.println("文件下载完成，文件大小（单位 byte）： " + downloadSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件删除测试
     */
    // @Test
    public void testDelete() {
        try {
            FdfsUtil.delete("group1/M00/00/00/rBD67l2BQFeERtLlAAAAABISex8903.jpg");
            boolean exists = FdfsUtil.exists("group1/M00/00/00/rBD67l2BQFeERtLlAAAAABISex8903.jpg");
            System.out.println("文件是否还存在： " + exists);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
