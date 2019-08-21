package com.cashierdesk.cmd;

import java.util.Scanner;

/**
 * @author 灵魂编程者
 * @Title: Command
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/21 14:16
 */
public interface Command {
    /*
    * 此接口的存在就是为了让当前包下
    * 所有实现了此接口的类都可以拥有这么一个Scanner对象
    * 不然在imp包下每隔Command从终端获取信息
    * 都需要new一个Scanner对象来使用
    * */
    Scanner scanner = new Scanner(System.in);

    //此时所有类通过这个Scanner对象写完命令之后
    //都要去操作Service，所以此处还需要写一个类去操作Service
    void execute(Subject subject);

    //执行当前操作需要判断是管理员还是用户


}
