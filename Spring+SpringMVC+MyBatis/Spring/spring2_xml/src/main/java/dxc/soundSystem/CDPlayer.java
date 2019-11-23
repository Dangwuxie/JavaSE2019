package dxc.soundSystem;

/**
 * @author 灵魂编程者
 * @Title: CDPlayer
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/23 14:35
 */
public class CDPlayer {

    private CompactDisc compactDisc;

    public CDPlayer() {
        System.out.println("CDPlayer的无参构造....");
    }

    public CDPlayer(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
        System.out.println("CDPlayer的有参构造......"+this.toString());
    }

    public void play(){

        System.out.println("cdplayer  ..."+this.toString());
        compactDisc.play();
    }
}
