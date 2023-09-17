package com.lhj.main;

import com.lhj.utils.HammingUtils;
import com.lhj.utils.SimHashUtils;
import com.lhj.utils.TxtUtils;
import org.junit.Test;

public class MainTest {



    @Test
    public void origTest(){
        String orig = TxtUtils.readTxt("D:/test/orig.txt");
        String copy = TxtUtils.readTxt("D:/test/orig.txt");
        String resultFileName = "D:/test/resultOrigTest.txt";
        double result = HammingUtils.getSimilarity(SimHashUtils.getSimHash(orig), SimHashUtils.getSimHash(copy));
        TxtUtils.writeTxt(result, resultFileName);
    }

    @Test
    public void addTest(){
        String orig = TxtUtils.readTxt("D:/test/orig.txt");
        String copy = TxtUtils.readTxt("D:/test/orig_0.8_add.txt");
        String resultFileName = "D:/test/resultAddTest.txt";
        double result = HammingUtils.getSimilarity(SimHashUtils.getSimHash(orig), SimHashUtils.getSimHash(copy));
        TxtUtils.writeTxt(result, resultFileName);
    }

    @Test
    public void delTest(){
        String orig = TxtUtils.readTxt("D:/test/orig.txt");
        String copy = TxtUtils.readTxt("D:/test/orig_0.8_del.txt");
        String resultFileName = "D:/test/resultDelTest.txt";
        double result = HammingUtils.getSimilarity(SimHashUtils.getSimHash(orig), SimHashUtils.getSimHash(copy));
        TxtUtils.writeTxt(result, resultFileName);
    }

    @Test
    public void dis1Test(){
        String orig = TxtUtils.readTxt("D:/test/orig.txt");
        String copy = TxtUtils.readTxt("D:/test/orig_0.8_dis_1.txt");
        String resultFileName = "D:/test/resultDis1Test.txt";
        double result = HammingUtils.getSimilarity(SimHashUtils.getSimHash(orig), SimHashUtils.getSimHash(copy));
        TxtUtils.writeTxt(result, resultFileName);
    }

    @Test
    public void dDis10Test(){
        String orig = TxtUtils.readTxt("D:/test/orig.txt");
        String copy = TxtUtils.readTxt("D:/test/orig_0.8_dis_10.txt");
        String resultFileName = "D:/test/resultDis10Test.txt";
        double result = HammingUtils.getSimilarity(SimHashUtils.getSimHash(orig), SimHashUtils.getSimHash(copy));
        TxtUtils.writeTxt(result, resultFileName);
    }

    @Test
    public void dis15Test(){
        String orig = TxtUtils.readTxt("D:/test/orig.txt");
        String copy = TxtUtils.readTxt("D:/test/orig_0.8_dis_15.txt");
        String resultFileName = "D:/test/resultDis15Test.txt";
        double result = HammingUtils.getSimilarity(SimHashUtils.getSimHash(orig), SimHashUtils.getSimHash(copy));
        TxtUtils.writeTxt(result,resultFileName);
    }

    @Test
    public void allTest(){
        String[] str = new String[6];
        str[0] = TxtUtils.readTxt("D:/test/orig.txt");
        str[1] = TxtUtils.readTxt("D:/test/orig_0.8_add.txt");
        str[2] = TxtUtils.readTxt("D:/test/orig_0.8_del.txt");
        str[3] = TxtUtils.readTxt("D:/test/orig_0.8_dis_1.txt");
        str[4] = TxtUtils.readTxt("D:/test/orig_0.8_dis_10.txt");
        str[5] = TxtUtils.readTxt("D:/test/orig_0.8_dis_15.txt");
        String resultFileName = "D:/test/resultAll.txt";
        for(int i = 0; i <= 5; i++){
            double result = HammingUtils.getSimilarity(SimHashUtils.getSimHash(str[0]), SimHashUtils.getSimHash(str[i]));
            TxtUtils.writeTxt(result, resultFileName);
        }
    }
}
