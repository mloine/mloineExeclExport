package com.mloine.execlexport.execl;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @className: Person
 * @Description:TOO
 * @Author:mloine
 * @Date：2019/6/2816:21
 **/
public class Person {

    @Excel(name = "ID")
    private Long id;

    @Excel(name = "用户名")
    private String username;

    @Excel(name = "密码",isExportField = false)
    private String password;

    @Excel(name = "入学日期")
    private Date start;

    @Excel(name = "学费")
    private BigDecimal sum;

    public Person(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person(Long id, String username, String password, Date start, BigDecimal sum) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.start = start;
        this.sum = sum;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", start=" + start +
                ", sum=" + sum +
                '}';
    }
}
