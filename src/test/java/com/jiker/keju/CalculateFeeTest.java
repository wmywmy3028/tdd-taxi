package com.jiker.keju;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static com.jiker.keju.util.CalculateFee.getRecepit;
import static org.junit.Assert.*;
public class CalculateFeeTest {
    /**
     * 行记录内容为空串
     */
    @Test(expected = NumberFormatException.class)
    public void parsing_line_is_empty_test(){
        List<String> lines = new ArrayList<>();
        lines.add("");
        getRecepit(lines);
    }
    /**
     * 行记录中不包含关键的数字信息
     */
    @Test(expected = NumberFormatException.class)
    public void parsing_line_not_contains_number_test(){
        List<String> lines = new ArrayList<>();
        lines.add(" 公里；等待 分钟");
        getRecepit(lines);
    }
    /**
     * 行记录格式错误
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void parsing_line_format_error_test(){
        List<String> lines = new ArrayList<>();
        lines.add("10公里；等待0分钟");
        getRecepit(lines);
    }
    /**
     * 公里数解析错误
     */
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
    /**
     * 被解析的行超过1行,每种计费方式覆盖
     */
    @Test
    public void more_than_one_line_test(){
        List<String> lines = new ArrayList<>();
        lines.add("1公里,等待0分钟");
        lines.add("7公里,等待1分钟");
        lines.add("12公里,等待3分钟");
        String receipt = getRecepit(lines);
        assertEquals("收费6元\n收费10元\n收费16元\n", receipt);
    }
}