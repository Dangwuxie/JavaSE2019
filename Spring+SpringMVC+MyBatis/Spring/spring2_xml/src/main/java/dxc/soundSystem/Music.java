package dxc.soundSystem;

/**
 * @author 灵魂编程者
 * @Title: Music
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/23 21:12
 */
public class Music {

    private String name;
    private Integer time;

    public Music() {
        System.out.println("music的构造函数......"+this.toString());
    }

    public Music(String name, Integer time) {
        this.name = name;
        this.time = time;
        System.out.println("music的构造函数......");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("在 "+this.toString()+"中注入name");
    }

    public void setTime(Integer time) {
        this.time = time;
        System.out.println("在 "+this.toString()+"中注入time");
    }

    public String getName() {
        return name;
    }

    public Integer getTime() {
        return time;
    }
}
