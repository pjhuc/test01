package main.pjhuc01.socket02;

import java.io.File;

public class FileTest {

    public static void main(String[] args) {
        File file = new File("D:\\file_1\\liuzengguang");
        File[] listFiles = file.listFiles();
        for (int i = 0; i < listFiles.length; i++) {
            System.out.println(listFiles[i].getName());
        }
    }

}
