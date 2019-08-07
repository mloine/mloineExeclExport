package com.mloine.execlexport.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;

import com.mloine.execlexport.easypoi.ExcelExport;
import com.mloine.execlexport.easypoi.ExcelImport;
import com.mloine.execlexport.easypoi.ExcelUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 插件easypoi引入 导入导出使用
 * 1.已验证 包含BigDecimal String Date类型 都已经验证ok
 * 2.已验证 1w的数据导入不成问题
 */
@RestController
@RequestMapping("/excelReader")
public class EasyPoiController {

    /**
     * excel导入
     *
     * @param file 导入文件
     * @return excel对象数组
     */
    @PostMapping(value = "/excelImport")
    public Object importExcel(@RequestParam("file") MultipartFile file) {

        //接收导入数组
        List<ExcelImport> excelImportList = null;
        try {
            excelImportList = ExcelImportUtil.importExcel(file.getInputStream(), ExcelImport.class, new ImportParams());
        } catch (Exception e) {
            e.printStackTrace();
        }

        excelImportList.stream().forEach(System.out::println);

        return excelImportList;
    }

    /**
     * excel 下载
     *
     * @param response response只能使用一次
     */
    @RequestMapping(value = "/excelExport")
    public void exportExcel(HttpServletResponse response) {
        //mock 下载导出测试数据
        ExcelExport export1 = new ExcelExport("测试1", "CN", new Date(),new BigDecimal(1));
        ExcelExport export2 = new ExcelExport("测试2", "EN", new Date(),new BigDecimal(123));
        List<ExcelExport> list = new ArrayList<>();
        list.add(export1);
        list.add(export2);
        int num = 1;
        while(num <=10000){
            list.add( new ExcelExport("测试"+num, "EN", new Date(),new BigDecimal(123)));
            num ++;
        }

    //参数配置
        ExportParams params = new ExportParams();
        //此处设置ExcelType HSSF为excel2003版本，XSSF为excel2007版本
        params.setType(ExcelType.XSSF);
        Workbook workbook = ExcelExportUtil.exportExcel(params, ExcelExport.class, list);
        ExcelUtil.downloadExcel(response, workbook, "excel-export");
    }


}
