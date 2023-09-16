package com.lhj.utils;


import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 读写txt文件
 *
 * @author 梁鸿俊
 */
public class TxtUtils {

    /**
     * 读txt文件，转换为字符串类型
     *
     * @param path 文件路径
     * @return 文件内容的字符串类型
     */
    public static String readTxt(String path) {

        StringBuilder str = new StringBuilder();
        String strLine;
        // 将txt文件逐行读出，拼接为字符串
        File file = new File(path);
        FileInputStream fileInputStream;

        try {
            fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // 拼接字符串
            while ((strLine = bufferedReader.readLine()) != null) {
                str.append(strLine);
            }
            // 关闭资源
            inputStreamReader.close();
            bufferedReader.close();
            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return str.toString();
    }

    /**
     * 将内容写入txt文件 （用于写入重复率到答案文件）
     *
     * @param content 写入的内容
     * @param path 写文件的文件路径
     */
    public static void writeTxt(double content,String path){

        String str = Double.toString(content);
        File file = new File(path);
        FileWriter fileWriter;

        try {
            fileWriter = new FileWriter(file, true);
            fileWriter.write(str, 0, (str.length() > 3 ? 4 : str.length()));
            fileWriter.write("\r\n");

            // 关闭资源
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
