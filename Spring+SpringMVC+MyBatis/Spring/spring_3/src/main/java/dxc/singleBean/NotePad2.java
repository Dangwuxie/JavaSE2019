package dxc.singleBean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author 灵魂编程者
 * @Title: NotePad
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/25 22:28
 */

@Component
//@Scope("singleton")
//@Scope(scopeName = "prototype")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@Lazy
public class NotePad2 {

    public NotePad2() {
        super();
        System.out.println("NotePad 22的无参构造......"+this.toString());
    }

    @PostConstruct
    public void init(){
        System.out.println("init方法22....");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy方法22");
    }
}
