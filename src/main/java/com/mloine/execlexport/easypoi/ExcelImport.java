package com.mloine.execlexport.easypoi;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

//@Data
public class ExcelImport {

    @Excel(name = "测试标题")
    private String title;

    @Excel(name="中英文类型",replace = {"中文_CN", "英文_EN"})
    private String type;

    @Excel(name = "日期",format = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    @Excel(name="金额")
    private BigDecimal num;

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public ExcelImport() {
    }

    @Override
    public String toString() {
        return "ExcelImport{" +
                "title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", num=" + num +
                '}';
    }

    public ExcelImport(String title, String type, Date date, BigDecimal num) {
        this.title = title;
        this.type = type;
        this.date = date;
        this.num = num;
    }
}
