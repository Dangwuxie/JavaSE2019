package dxc.Springwiring_auto.soundsystem;

import org.springframework.stereotype.Component;

/**
 * @author 灵魂编程者
 * @Title: CompactDisc
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/12 17:15
 */
//@Component
public class CompactDisc {

    public CompactDisc() {
        super();
        System.out.println("CompactDisc无参构造");
    }

    public void play(){
        System.out.println("正在播放音乐......");
    }
}
