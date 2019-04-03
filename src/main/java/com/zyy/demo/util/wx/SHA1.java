package com.zyy.demo.util.wx;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class SHA1 {

    /**
     * 串接arr参数，生成sha1 digest
     */
    public static String gen(String... arr){
        if(StringUtils.isAllEmpty(arr)){
            throw new IllegalArgumentException("有部分请求参数为空，非法请求" + Arrays.toString(arr));
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (String a : arr) {
            sb.append(a);
        }

        return DigestUtils.sha1Hex(sb.toString());
    }

    public static String genWithAmple(String... arr){
        if(StringUtils.isAllEmpty(arr)){
            throw new IllegalArgumentException("有部分请求参数为空，非法请求" + Arrays.toString(arr));
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            String a = arr[i];
            sb.append(a);
            if (i != arr.length - 1) {
                sb.append('&');
            }
        }
        return DigestUtils.sha1Hex(sb.toString());
    }
}
