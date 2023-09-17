package com.lhj.utils;

import org.junit.Test;

public class TxtUtilsTest {

    @Test
    public void readTxtTest() {
        // 路径存在，读文件成功
        String str = TxtUtils.readTxt("D:/test/orig.txt");
        String[] strings = str.split(" ");
        for (String string : strings) {
            System.out.println(string);
        }
    }

    @Test
    public void readTxtFailTest() {
        // 路径不存在，读文件失败
        String str = TxtUtils.readTxt("D:/test/123.txt");
    }

    @Test
    public void writeTxtTest() {
        // 路径存在，写答案文件成功
        double[] elem = {0.11, 0.22, 0.33, 0.44, 0.55};
        for (int i = 0; i < elem.length; i++) {
            TxtUtils.writeTxt(elem[i], "D:/test/result.txt");
        }
    }

    @Test
    public void writeTxtFailTest() {
        // 路径有误，写入答案文件失败
        double[] elem = {0.11, 0.22, 0.33, 0.44, 0.55};
        for (int i = 0; i < elem.length; i++) {
            TxtUtils.writeTxt(elem[i], "abc:/test/result.txt");
        }
    }

}
