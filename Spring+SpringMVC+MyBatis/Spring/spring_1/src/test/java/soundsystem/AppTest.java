package soundsystem;

import dxc.Springwiring_auto.soundsystem.AppConfig;
import dxc.Springwiring_auto.soundsystem.CDPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 灵魂编程者
 * @Title: AppTest
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/12 17:43
 */

//自动初始化spring上下文的结构，测试依赖已经添加上了
//这个可以自动初始化spring上下文环境
@RunWith(SpringJUnit4ClassRunner.class)
//加载配置类
@ContextConfiguration(classes = AppConfig.class)
public class AppTest {
    //spring通过反射机制作的依赖注入和自动装配；
    @Autowired
    private CDPlayer player;

    @Test
    public void testPlay(){

        /*ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CDPlayer player = context.getBean(CDPlayer.class);*/
        player.play();

    }
}
