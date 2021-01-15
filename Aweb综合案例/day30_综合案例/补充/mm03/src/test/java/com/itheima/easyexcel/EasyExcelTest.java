package com.itheima.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.itheima.dao.store.QuestionDao;
import com.itheima.domain.store.Question;
import com.itheima.utils.MybatisUtil;

import java.util.List;

/**
 * 0. 准备模板
 * 1. 导入依赖坐标
 * 2. 创建工作簿对象，使用模板
 * 3. 创建工作表对象
 * 4. 准备对象集合数据
 * 5. 写入填充
 *
 *
 * 明确概念
 *  一个xlsx文件对应一个工作簿
 *  一个xlsx中可以有多个sheet，每个sheet叫做一个工具表
 *
 *  EasyExcel核心的类  EasyExcel
 *
 */
public class EasyExcelTest {
    public static void main(String[] args) {

        // 创建工作簿对象，使用模板
        // Maven管理的项目，如果没有指定绝对路径 ，会默认相对于当前项目，写在相对路径下面
        // 模板文件可以同时被多个进程读，但是生成的目标文件不能被其他进程打开
        ExcelWriterBuilder workBook = EasyExcel.write("测试.xlsx", Question.class);

        // 使用模板
        // 类加载器会读取当前项目类路径下的文件
        // maven管理的项目下，所有的字节码文件和放在resources的配置文件，最终都会自动复制到target/classes中（类路径）
        workBook.withTemplate(EasyExcelTest.class.getClassLoader().getResourceAsStream("template" +
                ".xlsx"));

        // 创建工作表对象
        ExcelWriterSheetBuilder sheet = workBook.sheet();

        // 准备数据
        QuestionDao questionDao = MybatisUtil.getMapper(QuestionDao.class);
        List<Question> questions = questionDao.findAll();

        // 写入文件，填充数据，自动关闭资源
        sheet.doFill(questions);


    }

}
