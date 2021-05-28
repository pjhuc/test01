package main.pjhuc01.test20;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * 递归demo
 * 输出什么？
 */
public class Test20_04 {

    public static void main(String[] args) {
//        FileUtils fileUtils = new FileUtils();
        File file = new File("D:\\file_1\\liuzengguang\\210329\\crdin\\log");
        File file_pro = new File("D:\\file_1\\liuzengguang\\210329\\crdin\\log_pro");
        File[] files = file.listFiles();
        File[] files_pro = file_pro.listFiles();
        for(int i = 0;i < files.length;i++) {
            for (int j = 0; j < files_pro.length; j++) {
                if(files[i].getName().equals(files_pro[j].getName())) {
                    try {
                        System.out.println("log file name == "+files[i].getName());
                        System.out.println("log_pro file name == "+files_pro[j].getName());
                        boolean flag = FileUtils.contentEqualsIgnoreEOL(files[i],files_pro[j],"UTF-8");
                        System.out.println(flag);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

}
