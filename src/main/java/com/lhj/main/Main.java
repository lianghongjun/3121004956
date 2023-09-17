package com.lhj.main;

import com.lhj.utils.HammingUtils;
import com.lhj.utils.SimHashUtils;
import com.lhj.utils.TxtUtils;

/**
 * 主程序
 *
 * @author 梁鸿俊
 */
public class Main {
    public static void main(String[] args) {

        // 从命令行输入的路径读取文件，将文件内容转化为字符串
        String originTxt = TxtUtils.readTxt(args[0]);
        String otherTxt = TxtUtils.readTxt(args[1]);
        String resultFileName = args[2];

        // 求字符串对应的simHash值
        String simHash0 = SimHashUtils.getSimHash(originTxt);
        String simHash1 = SimHashUtils.getSimHash(otherTxt);
        // 由simHash值求出相似度(即论文查重率)
        double similarity = HammingUtils.getSimilarity(simHash0, simHash1);
        // 把查重率写入最后的结果文件中
        TxtUtils.writeTxt(similarity, resultFileName);
        System.exit(0);
    }
}
