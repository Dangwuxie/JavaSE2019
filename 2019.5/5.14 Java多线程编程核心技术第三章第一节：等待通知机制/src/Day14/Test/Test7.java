package Day14.Test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 线程间通信，字节流
 */

class WriteData{
    public void writeMethod(PipedOutputStream out){
        try{
            System.out.println("写入---");
            for (int i = 0;i<10;i++){
                String outData = "NO."+(i+1);
                out.write(outData.getBytes());
                System.out.print(outData+" ");
            }
            System.out.println();
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
class ReadData{
    public void readMethod(PipedInputStream input){
        try{
            System.out.println("读取---");
            byte[] byteArray = new byte[4];
            int readLength = input.read(byteArray);
            while (readLength != -1){
                String newData = new String(byteArray,0,readLength);
                System.out.println(newData);
                //再次检查可以读取到的长度；1
                readLength = input.read(byteArray);
            }
            System.out.println();
            input.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
class ThreadWrite extends Thread{
    private WriteData write;
    private PipedOutputStream out;

    public ThreadWrite(WriteData write, PipedOutputStream out) {
        this.write = write;
        this.out = out;
    }

    @Override
    public void run() {
        write.writeMethod(out);
    }
}
class ThreadRead extends Thread{
    private ReadData read;
    private PipedInputStream input;

    public ThreadRead(ReadData read, PipedInputStream input) {
        this.read = read;
        this.input = input;
    }

    @Override
    public void run() {
        read.readMethod(input);
    }
}
public class Test7 {
    public static void main(String[] args) {
        try{
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();
            PipedInputStream inputStream = new PipedInputStream();
            PipedOutputStream outputStream = new PipedOutputStream();

            outputStream.connect(inputStream);

            ThreadWrite threadWrite = new ThreadWrite(writeData,outputStream);
            threadWrite.start();
            Thread.sleep(2000);
            ThreadRead threadRead = new ThreadRead(readData,inputStream);
            threadRead.start();

        }catch (IOException e){
            e.printStackTrace();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }
}
