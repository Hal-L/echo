package KnowledgePoints.FileInputStream;

import java.io.FileInputStream;
import java.util.Arrays;

/**
 * @Author: fg
 * @Date: 2020/8/20 15:51
 */
public class Demo02 {
    /**
     * 文件读取,一次读取一个字节演示
     */
    public static void main(String[] args) throws Exception{
        // 创建一个流
        FileInputStream fis = new FileInputStream("myCode\\a.txt");
        // 定义临时变量
        byte[] bytes = new byte[3];
        int len;

        // 循环读取
        while ((len = fis.read(bytes)) != -1){
            // 查看len的值
            System.out.println(" len = " + len);
            // 查看数组的内容
            System.out.println(Arrays.toString(bytes));

            // 假设我要将数组中的数据写出到文件中
            // fos.write(bytes,0,len);
        }
    }
}
