package com.lhj.utils;

import org.junit.Test;

import java.util.Objects;

public class HammingUtilsTest {

    @Test
    public void getHammingDistanceTest() {
        String str0 = TxtUtils.readTxt("D:/test/orig.txt");
        String str1 = TxtUtils.readTxt("D:/test/orig_0.8_add.txt");

        int distance = HammingUtils.getHammingDistance(Objects.requireNonNull(SimHashUtils.getSimHash(str0)),
                Objects.requireNonNull(SimHashUtils.getSimHash(str1)));

        System.out.println("海明距离: " + distance);
        System.out.println("相似度: " + (100 - distance * 100 / 128) + "%");
    }

    @Test
    public void getHammingDistanceFailTest() {
        // 测试长度不同的情况
        String str0 = "10101010101";
        String str1 = "10101010";
        System.out.println(HammingUtils.getHammingDistance(str0, str1));
    }

    @Test
    public void getSimilarityTest() {
        String origTxt = TxtUtils.readTxt("D:/test/orig.txt");
        String copyTxt = TxtUtils.readTxt("D:/test/orig_0.8_add.txt");

        int distance = HammingUtils.getHammingDistance(Objects.requireNonNull(SimHashUtils.getSimHash(origTxt)),
                Objects.requireNonNull(SimHashUtils.getSimHash(copyTxt)));

        double similarity = HammingUtils.getSimilarity(SimHashUtils.getSimHash(origTxt), SimHashUtils.getSimHash(copyTxt));

        System.out.println("orig和copy的海明距离: " + distance);
        System.out.println("orig和copy的相似度:" + similarity);
    }
}
