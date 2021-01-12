package KnowledgePoints.mycollection.string;

import java.util.Scanner;

/*
 String 类:
    1.查看类
        String 类代表字符串。Java 程序中的所有字符串字面值（如 "abc" ）都作为此类的实例实现。
        翻译: String类的对象表示字符串对象,在java中凡是双引号引起来的内容就是String类的对象(字符串对象)

        特点:
            1.String 对象其实就是字符串对象
            2.String 对象是不可变的，是可以共享
            3.String 对象的底层就是一个字符数组,真正的是一个byte数组

    2.构造方法 -->创建对象,给对象的属性初始化
        String()   初始化一个新创建的 String 对象，使其表示一个空字符序列。
        String(byte[] bytes) 通过使用平台的默认字符集解码指定的 byte 数组，构造一个新的 String。
        String(char[] value)  分配一个新的 String，使其表示字符数组参数中当前包含的字符序列。
        String(String original) 初始化一个新创建的 String 对象，使其表示一个与参数相同的字符序列；
                                换句话说，新创建的字符串是该参数字符串的副本。
    3.成员方法
        判断功能的方法
        - public boolean equals (Object anObject) ：将此字符串与指定对象进行比较。
                1.参数是Object类型就可以接收任意对象
                2.如果要比较字符串里面的值是否相同,那么就需要使用equals()方法,不要用== 比较
                3.如果一个是null,一个不是null,那么建议用不是null的对象调用equals方法

        - public boolean equalsIgnoreCase (String anotherString) ：将此字符串与指定对象进行比较，忽略大小写。

         boolean contains(CharSequence s)  当且仅当此字符串包含指定的 char 值序列时，返回 true。
                // CharSequence 这种类型,就可以传一个String对象

         boolean endsWith(String suffix) 测试此字符串是否以指定的后缀结束。

         boolean isEmpty()  当且仅当 length() 为 0 时返回 true。

         boolean startsWith(String prefix) 测试此字符串是否以指定的前缀开始。

== 比较
对于基本数据类型: == 是做数值比较
对于引用数据类型: == 是做地址值比较

结论:
    通过直接双引号创建的字符串是在常量区,通过构造方法创建出来的字符串不是在常量区

        获取功能的方法
            - public int length () ：返回此字符串的长度。
            - public String concat (String str) ：将指定的字符串连接到该字符串的末尾。 拼接
            - public char charAt (int index) ：返回指定索引处的 char值。

            - public int indexOf (String str) ：返回指定子字符串第一次出现在该字符串内的索引。
             int lastIndexOf(String str)  返回指定子字符串在此字符串中最右边出现处的索引。
             int indexOf(int ch)  返回指定字符在此字符串中第一次出现处的索引。
              int lastIndexOf(int ch)  返回指定字符在此字符串中最后一次出现处的索引。

            - public String substring (int beginIndex) ：返回一个子字符串，从beginIndex开始截取字符串到字符串结尾。
            - public String substring (int beginIndex, int endIndex) ：返回一个子字符串，从beginIndex到endIndex截取字符串。含beginIndex，不含endIndex。
注意:
    字符串是有索引的,索引是从0开始的,最大索引是字符串长度-1

关于求长度:
    数组: 数组名.length
    集合: 集合名.size()
    字符串: 字符串对象名.length()


        转换功能的方法
        - public char[] toCharArray () ：将此字符串转换为新的字符数组。
        - public byte[] getBytes () ：使用平台的默认字符集将该 String编码转换为新的字节数组。
                    翻译: 把字符串转换为byte[]数组
        - public String replace (CharSequence target, CharSequence replacement) ：将与target匹配的字符串使用replacement字符串替换。
         String replace(char oldChar, char newChar)   返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。

        分割功能的方法
            - public String[] split(String regex) ：将此字符串按照给定的regex（规则）拆分为字符串数组。

 */
public class Demo1String {
    public static void main(String[] args) {
        /*
        统计字符个数
            键盘录入一个字符串，统计字符串中大小写字母及数字字符个数
            分析: 统计大写字母字符多少个,小写字母子符多少个,数字字符多少个
            思路:
                1.创建一个Scanner对象
                2.从控制台获取一个字符串
                3.定义三个计数器
                4.遍历该字符串,拿到每一个字符
                5.判断每一个字符,如果是大写字母,就计数,如果是小写字母也计数,如果是数字字符也计数
         */
//        1.创建一个Scanner对象
        Scanner sc = new Scanner(System.in);

//        2.从控制台获取一个字符串
        System.out.println("请输入一个字符串:");
        String str = sc.nextLine();

//        3.定义三个计数器
        int count1 = 0;// 用来记录大写字母的个数
        int count2 = 0;// 用来记录小写字母的个数
        int count3 = 0;// 用来记录数字字符的个数

//        4.遍历该字符串,拿到每一个字符
        for(int i = 0;i<str.length();i++){
//        5.判断每一个字符,如果是大写字母,就计数,如果是小写字母也计数,如果是数字字符也计数
            char ch = str.charAt(i);// 获取字符
            if(ch >= 'A' && ch <= 'Z'){
                count1++;
            }else if(ch >= 'a' && ch <= 'z'){
                count2++;
            }else if(ch >= '0' && ch <= '9'){
                count3++;
            }else{
                System.out.println("不是需要统计的字符");
            }
        }

        System.out.println("大写字母有:"+count1+"个");
        System.out.println("小写字母有:"+count2+"个");
        System.out.println("数字字符有:"+count3+"个");
    }

    private static void method08() {
    /*
    拼接字符串
        定义一个方法，把数组{1,2,3}按照指定个格式拼接成一个字符串。格式参照如下：[word1#word2#word3]。

     */
        //定义一个int类型的数组
        int[] arr = {1, 2, 3};

        String str = concat(arr);
        System.out.println(str);//[1#2#3]


       /* String str = "abcd";
        String s = str.toUpperCase();
        System.out.println(s);*/
    }

    public static String concat(int[] arr){
        // 1.第一步,创建一个字符串,用来存储拼接之后的字符串
        String str = "[";
        // 2.第二步,遍历数组,获取数组中的每一个元素
        for(int i = 0;i<arr.length;i++){
        // 3.第三步,按照格式进行拼接
            if(i == arr.length-1){
                str += arr[i] + "]";
            }else{
                str += arr[i] + "#";
            }
        }
        // 4.第四步,返回拼接后的字符串给调用者
        return str;
    }


    private static void method07() {
        String str = "abcd#bcde#cdef";

        String[] strArr = str.split("#");// 以 # 去拆分str字符串,把拆分出来的子字符串存入到strArr数组中

        for(int i = 0;i<strArr.length;i++){
            System.out.println(strArr[i]);
        }

        System.out.println(strArr.length);
    }

    private static void method06() {
        String str = "abcdabcd";// 字符串是不可变的

        String str1 = str.replace("bc","BC");
        System.out.println(str);// abcdabcd
        System.out.println(str1);// aBCdaBCd

        // 只替换单个字符
        String str2 = str.replace('c','C');
        System.out.println(str);// abcdabcd
        System.out.println(str2);// abCdabCd




        /*
        - public byte[] getBytes () ：使用平台的默认字符集将该 String编码转换为新的字节数组。
                    翻译: 把字符串转换为byte[]数组
         */
/*        byte[] bys = str.getBytes();// 把str字符串转换为byte数组

        for(int i = 0;i<bys.length;i++){
            System.out.println(bys[i]);
        }*/


//        - public char[] toCharArray () ：将此字符串转换为新的字符数组。
        // 把str字符串转换为字符数组
/*
        char[] chs = str.toCharArray();
        System.out.println(chs.length);

        for(int i = 0;i<chs.length;i++){
            System.out.println(chs[i]);
        }
*/
    }

    private static void method05() {
        String str = "abcdefg中国bcd10";

//        - public String substring (int beginIndex) ：返回一个子字符串，从beginIndex开始截取字符串到字符串结尾。
//        - public String substring (int beginIndex, int endIndex) ：
//                              返回一个子字符串，从beginIndex到endIndex截取字符串。含beginIndex，不含endIndex。
        String str1 = str.substring(7,9);
        System.out.println(str1);//中国


//        String str1 = str.substring(1);
//        System.out.println("从1索引开始截取,一直截取到末尾,得到的字符串是:"+str1);// bcdefg中国bcd10

//        String str2 = str.substring(0);
//        System.out.println("从0索引开始截取,一直截取到末尾,得到的字符串是:"+str2);// abcdefg中国bcd10


//        - public int indexOf (String str) ：返回 指定子字符串 第一次出现在该字符串内的索引。
//          int lastIndexOf(String str)  返回 指定子字符串 在此字符串中 最右边出现处的索引。
/*        int index = str.indexOf("bcd");
        System.out.println(index);//1

        int lastIndex = str.lastIndexOf("bcd");
        System.out.println(lastIndex);//9*/

        /*
              int indexOf(int ch)  返回 指定字符 在此字符串中第一次出现处的索引。
              int lastIndexOf(int ch)  返回 指定字符 在此字符串中最后一次出现处的索引
         */
//        int num = 'a';// int num = 97;
/*        int indexChar = str.indexOf('c');
        System.out.println("c字符第一次出现的索引:"+indexChar);// 2

        int lastIndexChar = str.lastIndexOf('c');
        System.out.println("c字符最后一次出现的索引:"+lastIndexChar);//10*/


//         - public char charAt (int index) ：返回指定索引处的 char值。
/*        char ch = str.charAt(0);
        System.out.println(ch);

        char endCh = str.charAt(str.length()-1);
        System.out.println(endCh);*/


//         - public String concat (String str) ：将指定的字符串连接到该字符串的末尾。 拼接
/*        String newStr = str.concat("2018");
        System.out.println(newStr);// abcdefg中国102018

        String newStr2 = str + 2018;
        System.out.println(newStr2);*/

//          - public int length () ：返回此字符串的长度。
//        int len = str.length();// 求str字符串的长度,也就是求这个str字符串有多少个字符
//        System.out.println(len);//11
    }

    private static void method04() {
    /*
             boolean contains(CharSequence s)  当且仅当此字符串包含指定的 char 值序列时，返回 true。
            // CharSequence 这种类型,就可以传一个String对象

             boolean endsWith(String suffix) 测试此字符串是否以指定的后缀结束。
            boolean startsWith(String prefix) 测试此字符串是否以指定的前缀开始。

             boolean isEmpty()  当且仅当 length() 为 0 时返回 true。

     */
//        String str1 = null;
//        boolean res1 = str1.isEmpty();// 异常  null是不能调用方法的

        String str2 = "";
        boolean res2 = str2.isEmpty();// true
        System.out.println(res2);

        String str = "abcdefg";
        boolean res = str.isEmpty();// 判断str字符串的长度是否为0
        System.out.println(res);// false


/*        String str = "abcdefg";
        boolean res = str.startsWith("abc");// 判断str字符串是否以 abc 开头
        System.out.println(res);*/


/*        String str = "abcdefg";
        boolean res = str.endsWith("efg");// 判断str字符串是否以 efg 结尾
        System.out.println(res);*/


/*        String str = "abcdefg";
        boolean res = str.contains("bcd");// 判断str字符串中是否包含bcd
        System.out.println(res);*/
    }

    private static void method03() {
        String str1 = "Abc";
        String str2 = new String("abc");

        System.out.println(str1.equals(str2));// false
        System.out.println(str1.equalsIgnoreCase(str2));// true
    }

    private static void method02() {
        String str1 = "abc";
        String str2 = null;
//        System.out.println(str1.equals(str2));// false
        System.out.println(str2.equals(str1));// NullPointerException 异常  null不能调用方法,如果调用就会出现空指针异常


/*         String str1 = "abc";// 常量区
         String str2 = "abc";// 常量区

         String str3 = new String("abc");// "abc"   堆区

        System.out.println(str1 == str2);// true
        System.out.println(str1 == str3);//false
        System.out.println(str2 == str3);// false

        System.out.println(str2.equals(str1));// true
        System.out.println(str1.equals(str2));// true

        System.out.println(str2.equals(str3));// true
        System.out.println(str1.equals(str3));// true*/




/*        int num1 = 10;
        int num2 = 20;
        System.out.println(num1 == num2);//false

        Student stu1 = new Student();
        Student stu2 = new Student();
        System.out.println(stu1 == stu2);// false*/
    }

    private static void method01() {
        // 第一种方式
        String str1 = new String();// 创建一个空字符串  ""

        // 第二种方式
        byte[] bys = {97,98,99};// a,b,c
        String str2 = new String(bys);// "abc"   把byte数组中的内容转换为字符串

        // 第三种方式
        char[] chs = {'J','Q','K'};
        String str3 = new String(chs);// "JQK"

        // 第四种方式
        String str4 = new String("A23");// "A23"

        // 第五种方式 直接双引号创建字符串
        String str5 = "itheima";//语法糖

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
    }
}
