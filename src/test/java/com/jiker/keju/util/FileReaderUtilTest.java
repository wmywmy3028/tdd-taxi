package com.jiker.keju.util;

import org.junit.After;
import org.junit.Test;
import java.io.*;
import java.util.List;
import static org.junit.Assert.*;
public class FileReaderUtilTest {
    File file = new File("src/main/resources/test.txt");
    @After
    public void tearDown() {
        file.delete();
    }
    /**
     * 文件名为null
     * @throws IOException 异常处理
     */
    @Test(expected = FileNotFoundException.class)
    public void file_name_is_null_test() throws Exception {
        FileReaderUtil.readFile("");
    }

    /**
     * 传入的文件名为空
     * @throws IOException 异常处理
     */
    @Test(expected = FileNotFoundException.class)
    public void file_name_is_empty_test() throws Exception {
        FileReaderUtil.readFile("");
    }

    /**
     *解析的文件不存在
     * @throws IOException 异常处理
     */
    @Test(expected = FileNotFoundException.class)
    public void file_not_exist_test() throws Exception {
        FileReaderUtil.readFile("src/main/resources/test.txt");
    }

    /**
     * 创建一个新的空文件
     * @throws Exception 异常处理
     */
    @Test
    public void file_exist_but_no_lines_test() throws Exception{
        //创建一个新的空文件
        file.createNewFile();
        List<String> lines =  FileReaderUtil.readFile("src/main/resources/test.txt");
        assertEquals("[]",lines.toString());
    }

    /**
     * 被读取的文件存在，且内容不为空
     * @throws Exception 异常处理
     */
    @Test
    public void file_exist_and_have_lines_and_read_success_test() throws Exception {
        List<String> lines =  FileReaderUtil.readFile("src/main/resources/testData.txt");
        assertNotNull(lines);
    }
}