package KnowledgePoints.网络编程.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Demo {
    public static void main(String[] args) throws IOException {
//1,创建一个Socket对象
        Socket socket = new Socket( "127.0.0.1",55555);
//2.获取一个I0流开始写数据
        OutputStream os = socket.getOutputStream();
        os.write("hello".getBytes());

//3.释放资源
        os.close();
    socket.close();

    }
}
