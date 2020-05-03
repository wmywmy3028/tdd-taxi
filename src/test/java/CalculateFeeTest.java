package com.jiker.keju.util;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static com.jiker.keju.util.CalculateFee.getRecepit;
import static org.junit.Assert.*;
public class CalculateFeeTest {
    @Test(expected = NumberFormatException.class)
    public void parsing_line_is_empty_test(){
        List<String> lines = new ArrayList<>();
        lines.add("");
        getRecepit(lines);
    }
    @Test(expected = NumberFormatException.class)
    public void parsing_line_not_contains_number_test(){
        List<String> lines = new ArrayList<>();
        lines.add(" 公里；等待 分钟");
        getRecepit(lines);
    }
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void parsing_line_format_error_test(){
        List<String> lines = new ArrayList<>();
        lines.add("10公里;等待0分钟");
        getRecepit(lines);
    }
    @Test(expected = NumberFormatException.class)
    public void distince_not_number_test(){
        List<String> lines = new ArrayList<>();
        lines.add("十公里,等待0分钟");
        getRecepit(lines);
    }
    @Test(expected = NumberFormatException.class)
    public void waitTime_not_number_test(){
        List<String> lines = new ArrayList<>();
        lines.add("10公里,等待分钟");
        getRecepit(lines);
    }
    @Test
    public void more_than_one_line_test(){
        List<String> lines = new ArrayList<>();
        lines.add("1公里,等待0分钟");
        lines.add("2公里,等待0分钟");
        lines.add("7公里,等待1分钟");
        lines.add("8公里,等待1分钟");
        lines.add("12公里,等待3分钟");
        String receipt = getRecepit(lines);
        assertEquals("收费6元\n收费6元\n收费10元\n收费11元\n收费16元\n", receipt);
    }
}