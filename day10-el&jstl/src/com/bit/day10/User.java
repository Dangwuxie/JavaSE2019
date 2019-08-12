package com.bit.day10;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Dangxuchao
 * @Title: User
 * @ProjectName day10-el&jstl
 * @Description: TODO
 * @date 2019/8/12 8:46
 */
public class User {
    private String name;
    private int age;
    private Date birthday;


    public User() {
    }

    public User(String name, int age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }
    public String getBirStr(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(birthday);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
