package com.jiker.keju;

import com.jiker.keju.util.FileReaderUtil;
import java.util.List;
import static com.jiker.keju.util.CalculateFee.getWaiteTimeAndDistanceFee;

/**
 * @author :wmy
 * @date :2020/05/01
 */
public class AppRunner {
    public static void main(String[] args) throws Exception {
        /*TODO
          1. args[0]为resources下的测试数据文件名，例如传入的args[0]值为"testData.txt"，注意并不包含文件路径。
          2. 你写的程序将把testDataFile作为参数加载此文件并读取文件内的测试数据，并对每条测试数据计算结果。
          3. 将所有计费结果拼接并使用\n分割，然后保存到receipt变量中。
         */
        //String testDataFile = args[0];
        String testDataFile = "testData.txt";
        //读取文件，以行为记录单位
        List<String> stringLines = FileReaderUtil.readFileByLines("src/main/resources/" + testDataFile);
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
    private static String getRecepit(List<String> stringLines) {
        String receipt = "";
        for (String strLine : stringLines) {
            int fee = getWaiteTimeAndDistanceFee(strLine);
            receipt = receipt.concat("收费" + fee + "元\n");
        }
        return receipt;
    }

}
