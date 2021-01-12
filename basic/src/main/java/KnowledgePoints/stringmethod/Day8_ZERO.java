package KnowledgePoints.stringmethod;

import java.util.Scanner;

public class Day8_ZERO {
    public static void main(String[] args) {
        TheStart();

    }

    private static void TheStart() {
        while (true) {
            System.out.println("\n1.常量优化。\r\n2.%取余，/取商。\r\n3.定义方法");
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入你需要检阅的题目:(1-9)");
            int i = sc.nextInt();
            switch (i) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    Demo1Scanner();
                    break;
                case 2:
                    Demo1String();
                    break;
                case 3:
                    StringConstructor();
                    break;
                case 4:
                    Demo1StringBuilder();
                    break;
                case 5:
                    Demo2StringBuilder();
                    break;
                case 6:
                    Demo3StringBuilder();
                    break;
                case 7:
                    Demo1Equals();
                    break;
                case 8:
                    Demo2Substring();
                    break;
                case 9:
                    Test();

                    break;
                default:
                    System.out.println("你输入的选择有误,请重新输入：");
                    break;
            }
        }
    }

    private static void Test() {
        System.out.println("\nTest22\r\n2.%取余，/取商。\r\n9.Test22");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你需要检阅的题目:(1-9)");
        int i = sc.nextInt();
        switch (i) {
            case 0:
                System.exit(0);
                break;
            case 1:
                Test1();
                break;
            case 2:
                Test2();
                break;
            case 3:
                Test3();
                break;
            case 4:
                Test4();
                break;
            case 5:
                Test5();
                break;
            case 6:
                Test6();
                break;
            case 7:
                Test7();
                break;
            case 8:
                Test8();
                break;
            case 9:
                Test9();

                break;
            default:
                System.out.println("你输入的选择有误,请重新输入：");
                break;
        }
    }

    private static void Test9() {
        /*
         * 需求：定义一个方法，把 int 数组中的数据按照指定的格式拼接成一个字符串返回 调用该方法，并在控制台输出结果。 例如，数组为int[] arr =
         * {1,2,3}; 执行方法后的输出结果为：[1, 2, 3]
         *
         * 思路： 1. 定义一个 int 类型的数组，用静态初始化完成数组元素的初始化 2. 定义一个方法，返回值类型 String，参数列表 int[] arr
         * 3. 在方法中用 StringBuilder 按照要求进行拼接，并把结果转成 String 返回 4. 调用方法，用一个变量接收结果 5. 输出结果
         */
        // 1. 定义一个 int 类型的数组，用静态初始化完成数组元素的初始化
        int[] arr = {1, 2, 3};
        // 4. 调用方法，用一个变量接收结果
        String s = arrayToString(arr);
        // 5. 输出结果
        System.out.println(s);
    }

    // 2. 定义一个方法，返回值类型 String，参数列表 int[] arr
    public static String arrayToString(int[] arr) {
        // 3. 在方法中用 StringBuilder 按照要求进行拼接，并把结果转成 String 返回
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                sb.append(arr[i]).append("]");
            } else {
                sb.append(arr[i]).append(", ");
            }
        }

        return sb.toString();
    }

    private static void Test8() {
        /*
         * 需求：键盘接受一个字符串，程序判断出该字符串是否是对称字符串，并在控制台打印是或不是 对称字符串：123321、111 非对称字符串：123123
         *
         * 思路： 1. 键盘录入一个字符串，用 Scanner 实现 2. 将键盘录入的字符串反转 3. 使用反转后的字符串，和原字符串进行比对 4.
         * 如果相同，则输出是对称字符串，反之输出不是对称字符串
         *
         */
        // 1. 键盘录入一个字符串，用 Scanner 实现
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入对称字符串:");
        String s = sc.nextLine();
        // 2. 将键盘录入的字符串反转
        // 将字符串封装为StringBuilder对象, 目的是为了掉用其反转的方法
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String reverseStr = sb.toString();
        // s : String
        // sb : StringBuilder
        // 3. 使用反转后的字符串，和原字符串进行比对
        if (s.equals(reverseStr)) {
            System.out.println("是对称字符串");
        } else {
            System.out.println("不是对称字符串");
        }
    }

    private static void Test7() {
        /*
         * 需求：以字符串的形式从键盘录入学生信息，例如：“张三 , 23” 从该字符串中切割出有效数据,封装为Student学生对象 思路： 1.
         * 编写Student类，用于封装数据 2. 键盘录入一个字符串，用 Scanner 实现 3. 根据逗号切割字符串，得到（张三）（23） String[]
         * split(String regex) ：根据传入的字符串作为规则进行切割 将切割后的内容存入字符串数组中，并将字符串数组返回 4.
         * 从得到的字符串数组中取出元素内容，通过Student类的有参构造方法封装为对象 5. 调用对象getXxx方法，取出数据并打印。
         *
         */
        // 2. 键盘录入一个字符串，用 Scanner 实现
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生信息:");
        String stuInfo = sc.nextLine();
        stuInfo = "张三,23";
        // 3. 根据逗号切割字符串，得到（张三）（23）
        String[] sArr = stuInfo.split(",");

        System.out.println(sArr[0]);
        System.out.println(sArr[1]);

        // 4. 从得到的字符串数组中取出元素内容，通过Student类的有参构造方法封装为对象
//            Student stu = new Student(sArr[0],sArr[1]);

        // 5. 调用对象getXxx方法，取出数据并打印。
//            System.out.println(stu.getName() + "..." + stu.getAge());

    }

    private static void Test6() {
        /*
         * 需求：键盘录入一个 字符串，如果字符串中包含（TMD），则使用***替换
         *
         * 思路： 1. 键盘录入一个字符串，用 Scanner 实现 2. 替换敏感词 String replace(CharSequence target,
         * CharSequence replacement) 将当前字符串中的target内容，使用replacement进行替换，返回新的字符串 3. 输出结果
         *
         */
        // 1. 键盘录入一个字符串，用 Scanner 实现
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入:");
        String s = sc.nextLine();
        // 2. 替换敏感词
        String result = s.replace("TMD", "***");
        // 3. 输出结果
        System.out.println(result);
    }

    private static void Test5() {
        /*
         * 需求：以字符串的形式从键盘接受一个手机号，将中间四位号码屏蔽 最终效果为：156****1234
         *
         * 思路： 1. 键盘录入一个字符串，用 Scanner 实现 2. 截取字符串前三位 3. 截取字符串后四位 4.
         * 将截取后的两个字符串，中间加上****进行拼接，输出结果
         *
         */
        // 1. 键盘录入一个字符串，用 Scanner 实现
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入手机号:");
        String telString = sc.nextLine();
        // 2. 截取字符串前三位
        String start = telString.substring(0, 3);
        // 3. 截取字符串后四位
        String end = telString.substring(7);
        // 4. 将截取后的两个字符串，中间加上****进行拼接，输出结果
        System.out.println(start + "****" + end);
    }

    private static void Test4() {
        /*
         * 需求：键盘录入一个字符串，统计该字符串中大写字母字符，小写字母字符，数字字符出现的次数(不考虑其他字符)
         *
         * 思路： 1. 键盘录入一个字符串，用 Scanner 实现 2. 要统计三种类型的字符个数，需定义三个统计变量，初始值都为0 3.
         * 遍历字符串，得到每一个字符 4. 判断该字符属于哪种类型，然后对应类型的统计变量+1
         * 假如ch是一个字符，我要判断它属于大写字母，小写字母，还是数字，直接判断该字符是否在对应的范围即可 大写字母：ch>='A' && ch<='Z'
         * 小写字母： ch>='a' && ch<='z' 数字： ch>='0' && ch<='9' 5. 输出三种类型的字符个数
         */
        // 1. 键盘录入一个字符串，用 Scanner 实现
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入:");
        String s = sc.nextLine();
        // 2. 要统计三种类型的字符个数，需定义三个统计变量，初始值都为0
        int bigCount = 0;
        int smallCount = 0;
        int numCount = 0;
        // 3. 遍历字符串，得到每一个字符
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            // 4. 判断该字符属于哪种类型，然后对应类型的统计变量+1
            if (c >= 'A' && c <= 'Z') {
                bigCount++;
            } else if (c >= 'a' && c <= 'z') {
                smallCount++;
            } else if (c >= '0' && c <= '9') {
                numCount++;
            }
        }

        // 5. 输出三种类型的字符个数
        System.out.println("大写字母字符:" + bigCount);
        System.out.println("小写字母字符:" + smallCount);
        System.out.println("数字字母字符:" + numCount);
    }

    private static void Test3() {
        /*
         * 需求：键盘录入一个字符串，使用程序实现在控制台遍历该字符串
         *
         * 思路： 1. 键盘录入一个字符串，用 Scanner 实现 2. 将字符串拆分为字符数组 public char[] toCharArray​(
         * )：将当前字符串拆分为字符数组并返回 3. 遍历字符数组
         *
         */
        // 1. 键盘录入一个字符串，用 Scanner 实现
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入:");
        String s = sc.nextLine();
        // 2. 将字符串拆分为字符数组
        char[] chars = s.toCharArray();
        // 3. 遍历字符数组
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
    }

    private static void Test2() {
        /*
         * 需求：键盘录入一个字符串，使用程序实现在控制台遍历该字符串
         *
         * 思路： 1. 键盘录入一个字符串，用 Scanner 实现 2. 遍历字符串，首先要能够获取到字符串中的每一个字符 public char
         * charAt​(int index)：返回指定索引处的char值，字符串的索引也是从0开始的 3. 遍历字符串，其次要能够获取到字符串的长度 public
         * int length​()：返回此字符串的长度 4. 遍历打印
         *
         */
        // 1. 键盘录入一个字符串，用 Scanner 实现
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入:");
        String s = sc.nextLine();
        // 2. 遍历字符串，首先要能够获取到字符串中的每一个字符
        for (int i = 0; i < s.length(); i++) {
            // i : 字符串的每一个索引
            char c = s.charAt(i);
            System.out.println(c);
        }
    }

    private static void Test1() {
        /*
         * 需求：已知用户名和密码，请用程序实现模拟用户登录。 总共给三次机会，登录之后，给出相应的提示
         *
         * 思路： 1. 已知用户名和密码，定义两个字符串表示即可 2. 键盘录入要登录的用户名和密码，用 Scanner 实现 3.
         * 拿键盘录入的用户名、密码和已知的用户名、密码进行比较，给出相应的提示。 字符串的内容比较，用equals() 方法实现 4.
         * 用循环实现多次机会，这里的次数明确，采用for循环实现，并在登录成功的时候，使用break结束循环
         */
        // 1. 已知用户名和密码，定义两个字符串表示即可
        String username = "admin";
        String password = "123456";
        // 2. 键盘录入要登录的用户名和密码，用 Scanner 实现
        Scanner sc = new Scanner(System.in);
        // 4. 用循环实现多次机会，这里的次数明确，采用for循环实现
        for (int i = 1; i <= 3; i++) {
            System.out.println("请输入用户名:");
            String scUsername = sc.nextLine();
            System.out.println("请输入密码:");
            String scPassword = sc.nextLine();
            // 3. 拿键盘录入的用户名、密码和已知的用户名、密码进行比较，给出相应的提示。
            if (username.equals(scUsername) && password.equals(scPassword)) {
                System.out.println("登录成功");
                break;
            } else {
                if (i == 3) {
                    System.out.println("您的登录次数已达到今日上限, 请明天再来");
                } else {
                    System.out.println("登录失败,您还剩余" + (3 - i) + "次机会");
                }

            }
        }
    }

    private static void Demo2Substring() {
        /*
         * String substring(int beginIndex) : 从传入的索引位置处，向后截取，一直截取到末尾，得到新的字符串并返回
         *
         * String substring(int beginIndex, int endIndex) ：
         * 从beginIndex索引位置开始截取，截取到endIndex索引位置，得到新字符串并返回（包含头，不包含尾）
         *
         */
        System.out.println("截取字符串");
        String s = "itheima";
        String ss = s.substring(2);
        System.out.println(ss);

        String sss = s.substring(0, 2);
        System.out.println(sss);
    }

    private static void Demo1Equals() {
        String s1 = "abc";
        String s2 = "ABC";
        String s3 = "abc";

        System.out.println("比较字符串内容");
        // equals : 比较字符串内容, 区分大小写
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));

        // equalsIgnoreCase : 比较字符串内容, 忽略大小写
        System.out.println(s1.equalsIgnoreCase(s2));
    }

    private static void Demo3StringBuilder() {
        /*
         * 成员方法: public StringBuilder append(任意类型) : 添加数据，并返回对象本身 public StringBuilder
         * reverse() : 返回相反的字符序列 public int length​() : 返回长度 (字符出现的个数) public String
         * toString() : 通过toString()就可以实现把StringBuilder转换为String
         */
        StringBuilder sb = new StringBuilder();
        // 链式编程: 如果一个方法返回的是对象类型, 对象就可以继续向下调用方法.
        sb.append("红色").append("蓝色").append("绿色");

        System.out.println("反转前:" + sb);

        sb.reverse();

        System.out.println("反转后:" + sb);

        System.out.println("sb中字符的个数为:" + sb.length());

        // public String toString() : 通过toString()就可以实现把StringBuilder转换为String
        String s = sb.toString();
        System.out.println(s);
    }

    private static void Demo2StringBuilder() {
        // public StringBuilder() : 创建一个空白可变字符串对象，可以看作为是一个容器，不含有任何内容
        StringBuilder sb = new StringBuilder();
        System.out.println(sb);

        // public StringBuilder(String str) : 根据字符串的内容，来创建可变字符串对象
        StringBuilder sb2 = new StringBuilder("abc");
        System.out.println(sb2);
    }

    private static void Demo1StringBuilder() {
        // StringBuilder 效率远比string要高
        long start = System.currentTimeMillis();
        System.out.println("获取1970年1月1日 0时0分0秒 到当前时间所经历过的毫秒值" + start);

        StringBuilder sb = new StringBuilder();
        System.out.println("循环前空对象" + sb);
        for (int i = 1; i <= 50000; i++) {
            sb.append(i);
        }

        System.out.println("循环后对象" + sb);

        long end = System.currentTimeMillis();
        System.out.println("获取1970年1月1日 0时0分0秒 到当前时间所经历过的毫秒值" + end);

        System.out.println(end - start);
    }

    private static void StringConstructor() {
        /*
         * String类常见构造方法: String s = “abc”; 直接赋值的方式创建字符串对象，内容就是abc
         *
         * 注意: String这个类比较特殊, 打印其对象名的时候, 不会出现内存地址 而是该对象所记录的真实内容.
         *
         * 面向对象-继承, Object类
         */
        // public String() : 创建一个空白字符串对象，不含有任何内容
        String s1 = new String();
        System.out.println(s1);

        // public String(char[] chs) : 根据字符数组的内容，来创建字符串对象
        char[] chs = {'a', 'b', 'c'};
        String s2 = new String(chs);
        System.out.println(s2);

        // public String(String original) : 根据传入的字符串内容，来创建字符串对象
        String s3 = new String("123");
        System.out.println(s3);
    }

    private static void Demo1String() {
        /*
         * Java程序中, 所有的双引号字符串, 都是String这个类的对象。
         *
         * 字符串是常量；它们的值在创建之后不能更改
         */
        String s1 = "abc123";
        int length = s1.length();
        System.out.println(length);

        s1 = "def"; // 这一步是让s1这个字符串类型的变量, 记录了一个新的对象。

        System.out.println(s1);
    }

    private static void Demo1Scanner() {
        // 1. 创建Scanner对象
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入:");
        // 2. 调用nextLine方法接收字符串
        // ctrl + alt + v : 快速生成方法的返回值
        String s = sc.nextLine();

        System.out.println(s);
        System.out.println("nextInt和nextLine方法配合使用的时候, nextLine方法就没有键盘录入的机会了");
        int num = sc.nextInt(); // 10 + 回车换行
        System.out.println("键盘录入数据的时候, 如果是字符串和整数一起接受, 建议使用next方法接受字符串:");
        String s1 = sc.nextLine();

        System.out.println(num);
        System.out.println(s1);
    }
}
