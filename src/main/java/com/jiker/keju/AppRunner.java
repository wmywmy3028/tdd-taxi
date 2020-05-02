package com.jiker.keju;

import com.jiker.keju.util.CalculateFee;
import com.jiker.keju.util.FileReaderUtil;
import java.util.List;
import static com.jiker.keju.util.CalculateFee.getWaiteTimeAndDistanceFee;

/**
 * 主类<br>
 * @author :wmy
 * @since  :2020/05/01
 * @date ：2020/05/02
 */
public class AppRunner {
    public static void main(String[] args) throws Exception {
        String testDataFile = args[0];
        //String testDataFile = "testData.txt";
        //读取文件，以行为记录单位
        List<String> stringLines = FileReaderUtil.readFile("src/main/resources/" + testDataFile);
        //获取文件中行记录计算费用拼接成的字串
        String receipt = CalculateFee.getRecepit(stringLines);
        System.out.println(receipt);
    }
}
