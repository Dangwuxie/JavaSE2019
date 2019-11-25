package dxc.singleBean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 灵魂编程者
 * @Title: AutowiredSingleBeanTest
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/25 22:36
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AutowiredSingleBeanTest {

    @Autowired
    private NotePad notePad;

    @Autowired
    private NotePad notePad2;

    @Test
    public void test(){
        System.out.println(notePad == notePad2);
    }

}
