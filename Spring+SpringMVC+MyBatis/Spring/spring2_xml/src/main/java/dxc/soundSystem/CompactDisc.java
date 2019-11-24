package dxc.soundSystem;


import java.util.List;
import java.util.Map;

/**
 * @author 灵魂编程者
 * @Title: CompactDisc
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/22 23:48
 */


public class CompactDisc {

    private String title;
    private String artist;
    //private Map<String,Music> tracks;
    private Music[] tracks;

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public Music[] getTracks() {
        return tracks;
    }

    public void setTitle(String title) {
        this.title = title;
        System.out.println("在 "+this.toString()+"中注入title");
    }

    public void setArtist(String artist) {
        this.artist = artist;
        System.out.println("在 "+this.toString()+"中注入artist");
    }

    public void setTracks(Music[] tracks) {
        this.tracks = tracks;
        System.out.println("在 "+this.toString()+"中注入tracks");
    }

    public CompactDisc(String title, String artist) {
        this.title = title;
        this.artist = artist;
        System.out.println("CompactDisc有参构造函数.......");
    }

    public CompactDisc(String title, String artist, Music[] tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc() {
        System.out.println("CompactDisc构造函数......" + this.toString());
    }

    public void play(){

        System.out.println("播放音乐....." + this.toString()+" "+this.title+"by"+this.artist);
        for (Music track : this.tracks) {
            System.out.println(" 音乐："+track.getName()+" 时长："+track.getTime());
        }

        /*for (String key:this.tracks.keySet()){
            System.out.println(" key :"+key);
            Music music = this.tracks.get(key);
            System.out.println(" 音乐："+music.getName()+" 时长："+music.getTime());
        }*/

    }
}
