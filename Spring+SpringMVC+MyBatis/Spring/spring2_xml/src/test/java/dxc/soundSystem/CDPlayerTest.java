package dxc.soundSystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 灵魂编程者
 * @Title: CDPlayerTest
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/23 14:46
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CDPlayerTest {

    @Autowired
    private CDPlayer cdPlayer1;

    @Autowired
    private CDPlayer cdPlayer2;

    @Autowired
    private CDPlayer cdPlayer3;

    @Test
    public void Test02(){
        cdPlayer1.play();
    }

    @Test
    public void Test03(){
        cdPlayer2.play();
    }

    @Test
    public void Test04(){
        cdPlayer3.play();
    }
}
