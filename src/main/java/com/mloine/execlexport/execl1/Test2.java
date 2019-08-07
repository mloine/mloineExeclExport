package com.mloine.execlexport.execl1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File("e:/test1.xls"));
            String fileName = "test1.xls";
            ImportExeclUtil importExeclUtil = new ImportExeclUtil();
            List<Object> objects = importExeclUtil.importDataFromExcel(new PersonOne(), fileInputStream, fileName);

            objects.stream().forEach(System.out::println);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
