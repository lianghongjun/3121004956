package com.lhj.exception;

import com.lhj.utils.SimHashUtils;
import org.junit.Test;

public class ContentShortExceptionTest {

    @Test
    public void shortStringExceptionTest(){
        //长度小于200
        System.out.println(SimHashUtils.getSimHash("练习时长两年半"));
    }
}
