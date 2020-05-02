package com.jiker.keju.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
/**
 * @author :wmy
 * @since  :2020/05/01
 * @date ：2020/05/02
 */
public class FileReaderUtil {
    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     *
     * @param fileName 文件名
     * @return 以行为单位读取文件 每行的记录
     * @throws Exception 异常处理
     */
    public static List<String> readFile(String fileName) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
        String tempString;
        List<String> stringLines = new ArrayList<>();
        // 一次读入一行，直到读入null为文件结束
        while ((tempString = reader.readLine()) != null) {
            stringLines.add(tempString);
        }
        reader.close();
        return stringLines;
    }
}
