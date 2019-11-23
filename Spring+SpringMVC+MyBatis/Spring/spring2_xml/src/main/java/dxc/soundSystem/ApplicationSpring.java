package dxc.soundSystem;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 灵魂编程者
 * @Title: ApplicationSpring
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/22 23:52
 */
public class ApplicationSpring {

    public static void main(String[] args) {
        System.out.println("Application is Running .......");

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        CompactDisc disc1 = (CompactDisc) context.getBean("compactDisc1 compactDisc12");
        //CompactDisc disc2 = (CompactDisc) context.getBean("compactDisc2");
        disc1.play();
        //disc2.play();

    }
}
