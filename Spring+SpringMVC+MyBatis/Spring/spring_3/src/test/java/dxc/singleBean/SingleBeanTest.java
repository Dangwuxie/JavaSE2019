package dxc.singleBean;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 灵魂编程者
 * @Title: SingleBeanTest
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/25 22:29
 */
public class SingleBeanTest {

    @Test
    public void test2(){

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        NotePad notePad1 = (NotePad) context.getBean("notePad");

        notePad1.destroy();
        /*NotePad notePad2 = (NotePad) context.getBean("notePad");

        System.out.println(notePad1 == notePad2);*/
    }
}
