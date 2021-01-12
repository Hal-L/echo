package KnowledgePoints.day17类加载.teacher.test01_yesterday;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceivedDemo {
    public static void main(String[] args) throws IOException {
        //创建接收端socketd对象
        DatagramSocket ds = new DatagramSocket(9999);
        //创建一个输出流写出图片数据到本地
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("day16/copy.jpg"));
        //循环接包
        byte[] bys = new byte[1024];
        while (true){
            //创建一个包用来接收数据
            DatagramPacket dp = new DatagramPacket(bys,bys.length);
            ds.receive(dp);

            if (new String(dp.getData(),0,dp.getLength()).equals("over")){
                break;
            }
            //写出数据
            bos.write(dp.getData(),0,dp.getLength());
            bos.flush();
        }
        //释放资源
        bos.close();
        ds.close();
    }
}
