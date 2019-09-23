package com.digitalx.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author pengjunlee
 * @create 2019-09-23 14:58
 */
public class CommentUtil {

    private static Set<String> eliminateComments = new HashSet<>();

    public static boolean isValidComment(String rateContent) {
        return !eliminateComments.contains(rateContent);
    }

    public static void loadAllEliminateComments() {
        try {
            ClassPathResource resource = new ClassPathResource("eliminate_comment.txt");
            InputStream inputStream = resource.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream,
                    "UTF-8"));
            String lineTxt = null;
            while ((lineTxt = br.readLine()) != null) {
                eliminateComments.add(lineTxt.trim());
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
