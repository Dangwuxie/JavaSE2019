package dxc.Springwiring_auto.soundsystem;

import org.springframework.stereotype.Component;

/**
 * @author 灵魂编程者
 * @Title: Power
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/12 18:00
 */

@Component
public class Power {

    public Power() {
        super();
        System.out.println("Power的构造方法...");
    }

    public void supply(){
        System.out.println("电源供电中...");

    }
}
