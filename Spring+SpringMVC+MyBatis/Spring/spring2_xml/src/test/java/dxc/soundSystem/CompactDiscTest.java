package dxc.soundSystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 灵魂编程者
 * @Title: CompactDiscTest
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/23 10:22
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-constructor.xml")
public class CompactDiscTest {

    @Autowired
    private CompactDisc compactDisc1;

    /*@Autowired
    private CompactDisc compactDisc2;
*/
    /*@Autowired
    @Qualifier("compactDisc2")
    private CompactDisc compactDisc3;*/

    @Test
    public void test01(){
        compactDisc1.play();
        //compactDisc2.play();
        //compactDisc3.play();
    }

}
