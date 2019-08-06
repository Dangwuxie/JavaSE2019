import java.io.*;

/**
 * @author Dangxuchao
 * @Title: Test7
 * @ProjectName IO复习
 * @Description: 内存操作流
 * @date 2019/8/6 22:17
 */
public class Test7 {
    public static void main(String[] args) throws IOException {
        String mas = "aaaaa";
        ByteArrayInputStream input = new ByteArrayInputStream(mas.getBytes());
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        int temp = 0;
        /*byte[] data = new byte[];
        output.write(input.read(data));*/
        //System.out.println(new String(data));
        while((temp = input.read())!=-1){
            System.out.println(temp);
            output.write(Character.toUpperCase(temp));
        }
        System.out.println(output);
        input.close();
        output.close();
    }

}
