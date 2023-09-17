package com.lhj.utils;

import org.junit.Test;

public class SimHashUtilsTest {

    @Test
    public void getHashTest(){
        String[] strings = {"Hello", "Hi", "Good", "Bad"};
        for (String string : strings) {
            String hash = SimHashUtils.getHash(string);
            System.out.println(hash.length());
            System.out.println(hash);
        }
    }
    @Test
    public void getSimHashTest(){
        String origTxt = TxtUtils.readTxt("D:/test/orig.txt");
        String copyTxt = TxtUtils.readTxt("D:/test/orig_0.8_add.txt");
        System.out.println(SimHashUtils.getSimHash(origTxt));
        System.out.println(SimHashUtils.getSimHash(copyTxt));
    }

}
