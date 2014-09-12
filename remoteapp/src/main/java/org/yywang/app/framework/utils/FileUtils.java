package org.yywang.app.framework.utils;

import org.yywang.app.framework.exception.AppSysException;

import java.io.*;

/**
 * 文件读写
 *
 * @author yywang
 */
public class FileUtils {

    /**
     * 文件读
     * 小文件
     *
     * @param filePath 文件路径
     * @return 字符串
     */
    public static String read(String filePath) {

        InputStream inputStream=null;
        try {
            File file=new File(filePath);
            inputStream = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            StringBuffer buffer = new StringBuffer();
            while (inputStream.read(bytes, 0, bytes.length) != -1) {
                buffer.append(new String(bytes));
            }
            return buffer.toString();
        } catch (FileNotFoundException e) {
            throw new AppSysException("文件路径错误", e);
        } catch (IOException e) {
            throw new AppSysException("文件IO", e);
        }finally {
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new AppSysException("文件关闭IO", e);
                }
            }
        }
    }

}
