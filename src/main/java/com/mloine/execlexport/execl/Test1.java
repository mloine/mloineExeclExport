package com.mloine.execlexport.execl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 * @className: Test1
 * @Description:TOO
 * @Author:mloine
 * @Date：2019/6/2816:31
 **/
public class Test1 {

    public static void main(String[] args) throws FileNotFoundException {
        ExcelUtil excelUtil = new ExcelUtil (Person.class);

        FileOutputStream fileOutputStream = new FileOutputStream ("e://test1.xls");
        ArrayList<Person> people = new ArrayList<> ();
        people.add (new Person (1l,"xyk","pwd",new Date (),new BigDecimal (123)));
        people.add (new Person (2l,"xyk2","pwd",new Date (),new BigDecimal (123)));
        people.add (new Person (3l,"xyk3","pwd",new Date (),new BigDecimal (123)));
        people.add (new Person (4l,"xyk4","pwd",new Date (),new BigDecimal (123)));
        people.add (new Person (5l,"xyk5","pwd",new Date (),new BigDecimal (123)));
        people.add (new Person (6l,"xyk6","pwd",new Date (),new BigDecimal (123)));

        excelUtil.exportExcel (people,"方案信息",fileOutputStream);
    }

}
