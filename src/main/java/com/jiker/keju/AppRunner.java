package com.jiker.keju;

import com.jiker.keju.util.CalculateFee;
import com.jiker.keju.util.FileReaderUtil;
import java.util.List;

public class AppRunner {
    public static void main(String[] args) throws Exception {
        String testDataFile = args[0];
        List<String> stringLines = FileReaderUtil.readFile("src/main/resources/" + testDataFile);
        String receipt = CalculateFee.getRecepit(stringLines);
        System.out.println(receipt);
    }
}
