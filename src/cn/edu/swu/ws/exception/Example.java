package cn.edu.swu.ws.exception;

import java.io.*;
import java.lang.RuntimeException;
import java.io.FileReader;

public class Example {
    public static void main(String[] args) throws IOException {
        int data[] = { 10, 20, 30, 40, 255 };
        FileOutputStream outputStream =  null;
        try {
            outputStream = new FileOutputStream("C:\\Users\\ws\\Desktop\\my.data");
            for (int i = 0; i<data.length; i++) {
                outputStream.write(data[i]);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("文件目录不存在:" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("数据输出错误:" + ex.getMessage());
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

}
