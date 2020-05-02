package com.jiker.keju.util;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * @author :wmy
 * @since  :2020/05/01
 * @date ：2020/05/02
 */
public class CalculateFee {
    /**
     * 通过读取的文件行，解析对应行中的行驶公里数和等待时间
     *
     * @param stringLine 文件中每一行记录
     * @return 当前行中的行驶公里数和等待时间对象
     */
    public static int getWaiteTimeAndDistanceFee(String stringLine) {
        //WaiteTimeAndDistanceBean bean = new WaiteTimeAndDistanceBean();
        //将每行记录以逗号分割，前面表示记录行驶公里数的，后半部分表示等待时间的
        String[] lineInput = stringLine.split(",");
        //将字符串中的非数字替换成空串，只留下数字，以获取行驶公里数和等待时间
        Pattern p = compile("[^\\d]");
        int distance = Integer.parseInt(p.matcher(lineInput[0]).replaceAll(""));
        int  waiteTime = Integer.parseInt(p.matcher(lineInput[1]).replaceAll(""));
        return getOneReceipt(distance,waiteTime);
    }

    /**
     * 根据行驶公里数和等待时间计算费用
     * @param distance 行驶公里数
     * @param waiteTime 等待时间
     * @return 费用
     */
    public static int getOneReceipt(int distance,int waiteTime) {
        int distanceSecond = 2;
        int distanceEight = 8;
        if (distance <= distanceSecond) {
            //起步价
            return (int) Math.round(6 + 0.25 * waiteTime);
        } else if (distance <= distanceEight) {
            //超过2公里，不超过8公里
            return (int) Math.round(4.4 + 0.8 * distance + 0.25 * waiteTime);
        } else {
            //超过8公里
            return (int) Math.round(1.2 + 1.2 * distance + 0.25 * waiteTime);
        }
    }
}
