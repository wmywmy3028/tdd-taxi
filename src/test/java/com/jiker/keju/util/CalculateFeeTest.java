package com.jiker.keju.util;
import org.junit.Test;

import static com.jiker.keju.util.CalculateFee.getWaiteTimeAndDistanceFee;
import static org.junit.Assert.*;
public class CalculateFeeTest {
    /**
     * 行记录内容为空串
     */
    @Test(expected = NumberFormatException.class)
    public void parsing_line_is_empty_test(){
        getWaiteTimeAndDistanceFee("");
    }

    /**
     * 行记录中不包含关键的数字信息
     */
    @Test(expected = NumberFormatException.class)
    public void parsing_line_not_contains_number_test(){
        getWaiteTimeAndDistanceFee(" 公里；等待 分钟");
    }

    /**
     * 行记录格式错误
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void parsing_line_format_error_test(){
        getWaiteTimeAndDistanceFee("10公里；等待0分钟");
    }

    /**
     * 行记录被成功解析，行记录中的行驶公里数不超过2
     */
    @Test
    public void parsing_line_success_and_distance_le_2_test(){
        int receipt = getWaiteTimeAndDistanceFee("1公里,等待0分钟");
        assertEquals(6, receipt);
    }

    /**
     * 行记录被成功解析，行记录中的行驶公里数超过2，但是不超过8
     */
    @Test
    public void distance_gt_2_le_8_test(){
        int receipt = getWaiteTimeAndDistanceFee("7公里,等待1分钟");
        assertEquals(10, receipt);
    }

    /**
     * 行记录被成功解析，行记录中的行驶公里数超过8
     */
    @Test
    public void distance_gt_8_test(){
        int receipt = getWaiteTimeAndDistanceFee("12公里,等待3分钟");
        assertEquals(16, receipt);
    }
}