package com.example.email.util;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件工具类
 */
@Component
public class FileReadUtils {

    /**
     * 读取text文件
     * @param inputStream 文件流
     * @return
     */
    public static List<String> readTxt(InputStream inputStream) throws IOException {

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String s;
        List<String> strings = new ArrayList<>();
        while ((s=bufferedReader.readLine())!=null){
            strings.add(s);
        }

        return strings;
    }
}
