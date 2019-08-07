package com.mloine.execlexport.execl1;

import com.mloine.execlexport.execl.Excel;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @className: Person
 * @Description:TOO
 * @Author:mloine
 * @Date：2019/6/2816:21
 **/
public class PersonOne {

    private String id;

    private String username;

    private String start;

    private String sum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public PersonOne() {
    }

    public PersonOne(String id, String username, String start, String sum) {
        this.id = id;
        this.username = username;
        this.start = start;
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", start=" + start +
                ", sum=" + sum +
                '}';
    }
}
