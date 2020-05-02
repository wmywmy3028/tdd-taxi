package com.jiker.keju.util;

import java.util.List;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;
/**
 * 计算路程和等待费用<br>
 * @author :wmy
 * @since  :2020/05/01
 * @date ：2020/05/02
 */
public class CalculateFee {
    public static int getWaiteTimeAndDistanceFee(String stringLine) {
        String[] lineInput = stringLine.split(",");
        Pattern p = compile("[^\\d]");
        int distance = Integer.parseInt(p.matcher(lineInput[0]).replaceAll(""));
        int  waiteTime = Integer.parseInt(p.matcher(lineInput[1]).replaceAll(""));
        return getOneReceipt(distance,waiteTime);
    }

    public static int getOneReceipt(int distance,int waiteTime) {
        if (distance <= 2) {
            return (int) Math.round(6 + 0.25 * waiteTime);
        } else if (distance <= 8) {
            return (int) Math.round(4.4 + 0.8 * distance + 0.25 * waiteTime);
        } else {
            return (int) Math.round(1.2 + 1.2 * distance + 0.25 * waiteTime);
        }
    }

    public static String getRecepit(List<String> stringLines) {
        String receipt = "";
        for (String strLine : stringLines) {
            int fee = getWaiteTimeAndDistanceFee(strLine);
            receipt = receipt.concat("收费" + fee + "元\n");
        }
        return receipt;
    }
}
