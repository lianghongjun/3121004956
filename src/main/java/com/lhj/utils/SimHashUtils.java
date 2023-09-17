package com.lhj.utils;

import com.hankcs.hanlp.HanLP;
import com.lhj.exception.ContentShortException;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.List;

/**
 * 计算SimHash值
 *
 * @author 梁鸿俊
 */
public class SimHashUtils {

    /**
     * 计算出字符串的hash值，并返回它的字符串类型
     *
     * @param str 传入的字符串
     * @return 返回str的hash值
     */
    public static String getHash(String str){

        try{
            // 使用MD5算法获得hash值
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            return new BigInteger(1,
                    messageDigest.digest(str.getBytes(StandardCharsets.UTF_8))).toString(2);

        } catch(Exception e){
            e.printStackTrace();
            return str;
        }
    }

    /**
     * 计算出字符串的simHash值，并返回它的字符串类型
     * @param str 传入的字符串
     * @return 返回str的simHash值
     */
    public static String getSimHash(String str){

        // 文本过短，HanLp无法取得关键字
        try{
            if (str.length() < 200) {
                throw new ContentShortException("文本过短！");
            }
        } catch (ContentShortException e){
            e.printStackTrace();
            return null;
        }

        // 数组表示特征向量，从0开始表示从高位到低位
        int[] v = new int[128];

        // 1、分词
        // 取出所有关键词
        List<String> wordList = HanLP.extractKeyword(str, str.length());

        int size = wordList.size();
        int i = 0;
        for(String keyword : wordList){
            // 2、获取hash值
            StringBuilder wordHash = new StringBuilder(getHash(keyword));
            if (wordHash.length() < 128) {
                // 若hash值少于128位，在低位以0补齐
                int dif = 128 - wordHash.length();
                for (int j = 0; j < dif; j++) {
                    wordHash.append("0");
                }
            }
            // 3、加权、合并
            for (int j = 0; j < v.length; j++) {
                // wordHash每一位与'1'进行比较
                if (wordHash.charAt(j) == '1') {
                    // 权重分10级，词频从高到低，取权重10~0
                    v[j] += (10 - (i / (size / 10)));
                } else {
                    v[j] -= (10 - (i / (size / 10)));
                }
            }
            i++;
        }
        // 4、降维
        StringBuilder simHash = new StringBuilder();
        for (int k : v) {
            // 从高位遍历到低位
            if (k <= 0) {
                simHash.append("0");
            } else {
                simHash.append("1");
            }
        }
        return simHash.toString();
    }

}
