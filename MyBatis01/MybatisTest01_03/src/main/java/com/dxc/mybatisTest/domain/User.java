package com.dxc.mybatisTest.domain;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 灵魂编程者
 * @Title: User
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/3 0:27
 */
@Data
public class User implements Serializable {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;


}
