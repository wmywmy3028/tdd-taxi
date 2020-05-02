package com.jiker.keju;

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
        String receipt = getRecepit(stringLines);
        System.out.println(receipt);
    }

    /**
     * 获取文件中每一行记录计算出的费用，并拼接起来
     *
     * @param stringLines 文件中的行记录集合
     * @return 文件记录计算出的费用拼接字串
     */
    public static String getRecepit(List<String> stringLines) {
        String receipt = "";
        for (String strLine : stringLines) {
            int fee = getWaiteTimeAndDistanceFee(strLine);
            receipt = receipt.concat("收费" + fee + "元\n");
        }
        return receipt;
    }
}
