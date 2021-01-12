package KnowledgePoints.mycollection.demo;
/*
复习:
    Scanner
        1.构造方法:
            Scanner sc = new Scanner(System.in);//创建了一个文本扫描器
        2.从控制台获取整数或者字符串
            nextInt();获取一个整数
            nextLine(); 获取一行数据
    Random
        1.构造方法
            Random r = new Random();// 创建了一个随机生成器
        2.生成随机数
            r.nextInt(int bounds);

    ArrayList
        1.集合类
        2.构造方法
            ArrayList<E> list = new ArrayList<>();// 推荐  创建一个ArrayList集合
            <> 泛型
            泛型: 用来限制集合中元素的数据类型
            E : 集合中元素的数据类型
            泛型不能写基本数据类型,只能写引用数据类型

            基本数据类型   对应的    引用数据类型(包装类类型)
            int                     Integer
            char                    Character
            byte                     Byte
            ........

            包装类类型和基本数据类型的转换
            自动拆箱: 把 包装类类型 自动转换为  基本数据类型
            自动装箱: 把 基本数据类型 自动包装为  包装类类型

        3.使用
            增     add(E e);
            删     remove(Object o)   remove(int index);
            查     get(int index);
            改     set(int index,E e);
            大小   size()
           判断是否包含某个元素   boolean contains(Object o);

 */
public class Demo {
    public static void main(String[] args) {

    }
}
