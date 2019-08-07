package com.mloine.execlexport.controller;

import com.mloine.execlexport.execl.ExcelUtil;
import com.mloine.execlexport.execl.Person;
import com.mloine.execlexport.util.RequestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ExeclController {

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "mloine";
    }

    /**
     * 导出测试
     */
    @GetMapping("/export")
    public void exportTest(){
        try {
            ArrayList<Person> people = new ArrayList<>();
            people.add (new Person (1l,"xyk","pwd",new Date(),new BigDecimal(123)));
            people.add (new Person (2l,"xyk2","pwd",new Date (),new BigDecimal (123)));
            people.add (new Person (3l,"xyk3","pwd",new Date (),new BigDecimal (123)));
            people.add (new Person (4l,"xyk4","pwd",new Date (),new BigDecimal (123)));
            people.add (new Person (5l,"xyk5","pwd",new Date (),new BigDecimal (123)));
            people.add (new Person (6l,"xyk6","pwd",new Date (),new BigDecimal (123)));

            ExcelUtil<Person> personExcelUtil = new ExcelUtil<Person>(Person.class);

           /*
                FileOutputStream fileOutputStream = new FileOutputStream ("e://test11.xls");
                personExcelUtil.exportExcel(people,"测试",fileOutputStream);
           */

            personExcelUtil.exportExcelToWeb(people,"测试", RequestUtils.currentHttpServletResponse());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 导入测试
     */
    @PostMapping("/import")
    @ResponseBody
    public Object importTest(@RequestBody MultipartFile file){
        
        ExcelUtil<Person> personExcelUtil = new ExcelUtil<Person>(Person.class);
        List<Person> test = null;

        try {
             //泛型直接转化object导入不好用
             test = personExcelUtil.importExcel(null, file.getInputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return test;
    }

}
