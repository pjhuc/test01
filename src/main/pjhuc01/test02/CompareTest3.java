package main.pjhuc01.test02;


import com.brilliance.eibs.core.exception.InterfaceException;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class CompareTest3 {

    public static void main(String[] args) {
        String resFilePath = "D:\\file_1\\yangzhikai\\191030\\commons.xml";
        String distFolder = "D:\\honor 8";
        System.out.println(copyFile(resFilePath, distFolder));
    }
    public static boolean copyFile (String resFilePath, String distFolder){
        boolean copy = false;

        try {
            File resFile = new File(resFilePath);
            File distFile = new File(distFolder);
            if (resFile.isDirectory()) {
                FileUtils.copyDirectoryToDirectory(resFile, distFile);
            } else if (resFile.isFile()) {
                FileUtils.copyFileToDirectory(resFile, distFile, true);
            }

            copy = true;
            return copy;
        } catch (Exception var5) {
            throw new InterfaceException("00411", "file copy error:", var5);
        }
    }
}
