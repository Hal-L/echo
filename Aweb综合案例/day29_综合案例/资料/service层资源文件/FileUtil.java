package com.itheima.utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 文件上传下载工具类
 *
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public class FileUtil {

    /**
     * @param byteArrayOutputStream 将文件内容写入ByteArrayOutputStream
     * @param response              HttpServletResponse	写入response
     * @param returnName            返回的文件名
     */
    public static void download(ByteArrayOutputStream byteArrayOutputStream, HttpServletResponse response, String returnName) throws IOException {
        //1.设置响应字符集
        response.setContentType("application/octet-stream;charset=utf-8");
        //2.解决文件名乱码
        returnName = response.encodeURL(new String(returnName.getBytes(), "iso8859-1"));            //保存的文件名,必须和页面编码一致,否则乱码
        //3.设置响应消息头：告知浏览器以下载方式打开
        response.addHeader("Content-Disposition", "attachment;filename=" + returnName);
        //4.设置响应正文的大小
        response.setContentLength(byteArrayOutputStream.size());
        //5.获取字节输出流
        ServletOutputStream outputstream = response.getOutputStream();    //取得输出流
        //6.把内容写到字节数组输出流缓冲区的中
        byteArrayOutputStream.writeTo(outputstream);                    //写到输出流
        //7.释放输出流
        byteArrayOutputStream.close();                                    //关闭
        //8.刷出缓冲区的内容
        outputstream.flush();                                            //刷数据
    }


    /**
     * 文件上传的方法
     *
     * @param filePath 要保存的文件路径
     * @param fileName 要使用唯一化的文件名
     * @param items    表单中的文件项集合
     * @throws Exception 当不支持文件上传时，抛出异常
     * @return 返回文件名
     */
    public static String uploadFile(String filePath, String fileName,List<FileItem> items) throws Exception {
        String returnName = "";
        //1.判断传入的目录是否存在
        File file = new File(filePath);
        if (!file.exists()) {
            //创建目录
            file.mkdirs();
        }
        //2.遍历文件项集合
        for (FileItem item : items) {
            //3.判断是不是文件
            if (!item.isFormField()) {//非表单字段即是文件
                //没有文件名即表示没有文件内容
                if(StringUtils.isBlank(item.getName())){
                    continue;
                }
                //4.设置文件名
                returnName = fileName+"_"+item.getName() ;
                //5.写文件
                item.write(new File(file, fileName));
                //6.删除临时文件
                item.delete();
            }
        }
        return returnName;
    }


    /**
     * 获取指定路径下的文件
     * @param dir
     * @param fileNames
     */
    public static void findFileList(File dir , List<String> fileNames){
        if (!dir.exists() || !dir.isDirectory()) {// 判断是否存在目录
            return;
        }
        String[] files = dir.list();// 读取目录下的所有目录文件信息
        for (int i = 0; i < files.length; i++) {// 循环，添加文件名或回调自身
            File file = new File(dir, files[i]);
            if (file.isFile()) {// 如果文件

                fileNames.add(dir + "\\" + file.getName());// 添加文件全路径名
//                fileNames.add(file.getName());// 添加文件全路径名
            } else {// 如果是目录
                findFileList(file, fileNames);// 回调自身继续查询
            }
        }
    }
}
