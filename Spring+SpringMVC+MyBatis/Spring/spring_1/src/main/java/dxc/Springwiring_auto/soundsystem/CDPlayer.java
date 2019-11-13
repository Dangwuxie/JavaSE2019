package dxc.Springwiring_auto.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 灵魂编程者
 * @Title: CDPlayer
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/12 17:20
 */

@Component
public class CDPlayer {

    @Autowired(required = false)
    private CompactDisc cd;

    @Autowired
    private Power power;

    /*@Autowired
    public void setCd(CompactDisc cd) {
        this.cd = cd;
        System.out.println("setCD的set方法......");
    }

    @Autowired
    public void setPower(Power power) {
        this.power = power;
        System.out.println("setPower的set方法......");
    }*/

    /*@Autowired
    public void prepare(CompactDisc cd,Power power){
        this.cd = cd;
        this.power = power;
        System.out.println("调用了prepare方法.......");
    }*/

    public CDPlayer() {
        super();
        System.out.println("CP Player....构造方法");
    }

    //自动装配；创建对象以及对象和对象之间的依赖关系；
    /*@Autowired
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
        System.out.println("cd player 的有参构造函数");
    }
*/

    /*@Autowired
    public CDPlayer(CompactDisc cd, Power power) {
        this.cd = cd;
        this.power = power;
        System.out.println("CDPlayer的多参数构造方法");
    }*/

    public void play(){

        power.supply();
        if (cd != null){
            cd.play();
        }

    }
}







