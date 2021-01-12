package KnowledgePoints.day17类加载.teacher.test01_yesterday;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        //创建发送端socketd对象
        DatagramSocket ds = new DatagramSocket();
        //创建一个输入流用来读取本地图片
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("d:/liuyan.jpg"));
        //循环发包
        byte[] bys = new byte[1024];
        int len;
        while ((len = bis.read(bys)) != -1){
            //打包
            DatagramPacket dp = new DatagramPacket(bys,len, InetAddress.getLocalHost(),9999);
            //发送
            ds.send(dp);
            //休眠2毫秒,发包有序,接包也有时间接收
            Thread.sleep(2);
        }

        //写一个结束标记
        byte[] b = "over".getBytes();
        DatagramPacket dp = new DatagramPacket(b,b.length, InetAddress.getLocalHost(),9999);
        //发送
        ds.send(dp);

        //释放资源
        bis.close();
        ds.close();
    }
}
