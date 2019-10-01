package com.cashierdesk.cmd.annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @author 灵魂编程者
 * @Title: AdminCommand
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/21 14:41
 */

//Retention(RetentionPolicy.RUNTIME)：
// 源注解，加载注解上面的注解,注解不仅被保存到class文件中，
//runtime的意思就是运行之后信息会保存到class文件，后面需要使用反射；
// jvm加载class文件之后仍然存在
//Target说明了Annotation所修饰的对象范围，用于描述类接口或enumerate生命
// Type代表可以修饰类
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AdminCommand {
    
}
