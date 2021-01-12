package KnowledgePoints.网络编程.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(55555);
        System.out.println(111);
        Socket accept = ss.accept();
        System.out.println(222);
        InputStream is = accept.getInputStream();
        int b;
        while ((b = is.read()) != -1) {
            System.out.print((char)b);
        }
        System. out.println("看看我执行了吗?");
        //4.释放资源
        is.close();
        ss.close();
    }
}

