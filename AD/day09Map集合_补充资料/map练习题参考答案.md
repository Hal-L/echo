# 练习题

## 知识点

Map

### 题目1（加强训练）

需求：Map集合中包含5对元素: "邓超"->"孙俪", "李晨"->"范冰冰", "刘德华"->"柳岩", “黄晓明”->” Baby”,“谢霆锋”->”张柏芝”。使用keySet方式迭代出Map集合中的元素。

#### 训练目标

#### 训练提示

#### 参考方案

#### 操作步骤

1. 创建HashMap 

2. 使用put方法添加元素 

3. 使用keySet方法获取所有的键 

4. 获取到keySet的迭代器 

5. 循环判断迭代器是否有下一个元素 

6. 使用迭代器next方法获取到一个键 

7. 通过一个键找到一个值 

8. 输出键和值 

#### 参考答案

```java
public class Test22 {
    public static void main(String[] args) {
        // 1.创建HashMap
        HashMap<String, String> hm = new HashMap<String, String>();

        // 2.使用put方法添加元素
        hm.put("邓超", "孙俪");
        hm.put("李晨", "范冰冰");
        hm.put("刘德华", "柳岩");
        hm.put("黄晓明", "Baby");
        hm.put("谢霆锋", "张柏芝");

        // 3.使用keySet方法获取所有的键
        Set<String> keySet = hm.keySet();

        // 4.获取到keySet的迭代器
        Iterator<String> it = keySet.iterator();

        // 5.循环判断迭代器是否有下一个元素
        while (it.hasNext()) {
            // 6.使用迭代器next方法获取到一个键
            String key = it.next();

            // 7.通过一个键找到一个值
            String value = hm.get(key);

            // 8.输出键和值
            System.out.println(key + " - " + value);
        }
    }
}
```

### 题目2（加强训练）

需求：研发部门有5个人，信息如下：（姓名-工资）【柳岩=2100, 张亮=1700, 诸葛亮=1800, 灭绝师太=2600, 东方不败 =3800】,将以上员工的相关信息存放在适合的集合中,给柳岩涨工资300,迭代出每个元素的内容输出到控制台。

#### 训练目标

#### 训练提示

#### 参考方案

#### 操作步骤

1. 定义HashMap,姓名作为key,工资作为value 

2. 使用put方法添加需要的元素 

3. 获取到柳岩的工资 

4. 修改柳岩的工资为当前工资加上300 

5. 使用增强for+keySet迭代出每个员工的工资 

#### 参考答案

```java
public class Test22 {
    public static void main(String[] args) {
        // 1.定义HashMap,姓名作为key,工资作为value
        HashMap<String, Integer> map = new HashMap<String,Integer>();

        // 2.使用put方法添加需要的元素
        map.put("柳岩", 2100);
        map.put("张亮", 1700);
        map.put("诸葛亮", 1800);
        map.put("灭绝师太", 2600);
        map.put("东方不败", 3800);

        // 3.获取到柳岩的工资
        int salary = map.get("柳岩");

        // 4.修改柳岩的工资为当前工资加上300
        map.put("柳岩", salary + 300);

        // 5.使用增强for+keySet迭代出每个员工的工资
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println(key + " -- " + map.get(key));
        }
    }
}
```

### 题目3（加强训练）

需求：使用LinkedHashMap保存学生对象；要求：

1. 学生具有学号、姓名和成绩三个属性；

2. 其中，学号不能重复；

#### 训练目标

#### 训练提示

#### 参考方案

#### 操作步骤

#### 参考答案

```java
class D5.DemoTostring.Student{
	private int num;//学号
	private String name;//姓名
	private double score;//分数
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public D5.DemoTostring.Student(int num, String name, double score) {
		super();
		this.num = num;
		this.name = name;
		this.score = score;
	}
	public D5.DemoTostring.Student() {}
	public String toString() {
		return "D5.DemoTostring.Student [num=" + num + ", name=" + name + ", score=" + score + "]";
	}
}
```

```java
class Test22{
	public static void main(String[] args) {
		//因为学生的学号唯一，所以使用学号作键，学生对象作值
		LinkedHashMap<Integer,D5.DemoTostring.Student> map = new LinkedHashMap<>();
		D5.DemoTostring.Student stu1 = new D5.DemoTostring.Student(10,"张三",56);
		D5.DemoTostring.Student stu2 = new D5.DemoTostring.Student(11,"李四",11);
		D5.DemoTostring.Student stu3 = new D5.DemoTostring.Student(12,"王五",67);
		D5.DemoTostring.Student stu4 = new D5.DemoTostring.Student(13,"赵六",88);
		map.put(stu1.getNum(), stu1);
		map.put(stu2.getNum(), stu2);
		map.put(stu3.getNum(), stu3);
		map.put(stu4.getNum(), stu4);
		System.out.println(map);
	}
}
```

### 题目4（综合训练）

需求：使用集合保存并按以下格式输出下列数据：

河北省:

​		秦皇岛市:[海港区, 山海关区, 北戴河区, 昌黎县]

​		唐山市:[路北区, 路南区, 古冶区, 开平区]

​		石家庄市:[石家庄市, 长安区, 桥东区, 桥西区, 新华区；]

河南省:

​		郑州市:[中原区, 金水区, 二七区, 管城回族区]

​		洛阳市:[西工区, 老城区, 涧西区, 洛龙区]

​		开封市:[鼓楼区, 龙亭区, 顺河回族区, 禹王台区]

#### 训练目标

#### 训练提示

#### 参考方案

#### 操作步骤

#### 参考答案

```java
public static void main(String[] args) {
		//创建一个Map集合用于保存所有数据
		Map<String,Map<String,List<String>>> map = new HashMap<>();
		
		//创建集合保存河南省的信息
		Map<String,List<String>> m1 = new HashMap<>();
		//创建一个List集合保存一个市的行政区域信息
		List<String> list1 = new ArrayList<>();
		Collections.addAll(list1, "中原区","金水区","二七区","管城回族区");
		m1.put("郑州市", list1);
		list1 = new ArrayList<>();
		Collections.addAll(list1, "鼓楼区","龙亭区","顺河回族区","禹王台区");
		m1.put("开封市", list1);
		list1 = new ArrayList<>();
		Collections.addAll(list1, "西工区","老城区","涧西区","洛龙区");
		m1.put("洛阳市", list1);
		map.put("河南省", m1);
		//创建集合保存河北省的信息
		m1 = new HashMap<>();
		//创建一个List集合保存一个市的行政区域信息
		list1 = new ArrayList<>();
		Collections.addAll(list1, "石家庄市","长安区","桥东区","桥西区","新华区；");
		m1.put("石家庄市", list1);
		list1 = new ArrayList<>();
		Collections.addAll(list1, "路北区","路南区","古冶区","开平区");
		m1.put("唐山市", list1);
		list1 = new ArrayList<>();
		Collections.addAll(list1, "海港区","山海关区","北戴河区","昌黎县");
		m1.put("秦皇岛市", list1);
		map.put("河北省", m1);
		//遍历输出
		for (String sheng : map.keySet()) {
			System.out.println(sheng+":");
			Map<String, List<String>> map2 = map.get(sheng);
			for (String shi : map2.keySet()) {
				System.out.println("\t"+shi + ":" + map2.get(shi));
			}
		}
}
```

### 题目5（综合训练）

需求：一个年级有若干个班级，每个班级有若干个学生；要求：时

1. 学生具有学号、姓名和成绩，学号和学生信息是一一对应的；

2. 使用集合保存这个年级的所有学生的信息，然后遍历输出；

#### 训练目标

#### 训练提示

#### 参考方案

#### 操作步骤

#### 参考答案

```java
class D5.DemoTostring.Student{
	private int num;//学号
	private String name;//姓名
	private double score;//分数
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public D5.DemoTostring.Student(int num, String name, double score) {
		super();
		this.num = num;
		this.name = name;
		this.score = score;
	}
	public D5.DemoTostring.Student() {}
	public String toString() {
		return "D5.DemoTostring.Student [num=" + num + ", name=" + name + ", score=" + score + "]";
	}
}
```

```java
class Test22{
	public static void main(String[] args) {
		//创建一个集合，用于保存年级信息
		List<HashMap<Integer,D5.DemoTostring.Student>> grade = new ArrayList<>();
		//创建一个集合保存一个班级的学生信息；
		//因为学生的学号和学生信息具有一一对应的关系，所以使用Map集合保存；
		//因为学生的学号唯一，所以使用学号作键，学生对象作值
		HashMap<Integer,D5.DemoTostring.Student> class1 = new HashMap<>();
		//创建两个学生对象，保存到班级中
		D5.DemoTostring.Student stu1 = new D5.DemoTostring.Student(10,"张三",56);
		D5.DemoTostring.Student stu2 = new D5.DemoTostring.Student(11,"李四",11);
		class1.put(stu1.getNum(), stu1);
		class1.put(stu2.getNum(), stu2);
		//将这个班级添加到年级集合中
		grade.add(class1);
		//创建几个学生对象，保存到另一个班级中
		HashMap<Integer,D5.DemoTostring.Student> class2 = new HashMap<>();
		D5.DemoTostring.Student stu3 = new D5.DemoTostring.Student(12,"王五",67);
		D5.DemoTostring.Student stu4 = new D5.DemoTostring.Student(13,"赵六",88);
		class2.put(stu3.getNum(), stu3);
		class2.put(stu4.getNum(), stu4);
		//将这个班级添加到年级集合中
		grade.add(class2);
		//遍历集合
		for (HashMap<Integer, D5.DemoTostring.Student> hashMap : grade) {
			for (Integer num : hashMap.keySet()) {
				System.out.println("学号" + num + "的学生信息是："+hashMap.get(num));
			}
		}
	}
}
```

### 题目6（综合扩展）

需求：根据需求补足代码：

​	对给定的数字列表进行分组，要求返回的Map中，Key为数字，Value为该数字出现的列表。
​	 例如，输入的数字列表为：[1,2,3,3,4,2]，
​	 那么返回值应为：{1=[1],2=[2,2],3=[3,3],4=[4]}

```java
/**
	 * 对给定的数字列表进行分组，要求返回的Map中，Key为数字，Value为该数字出现的列表。
	 * 例如，输入的数字列表为：[1,2,3,3,4,2]，
	 * 那么返回值应为：{1=[1],2=[2,2],3=[3,3],4=[4]}
	 */
	public static Map<Integer,List<Integer>> classify(Collection<Integer> numbers){
		//创建一个Map集合，用于保存需要返回的数据
		Map<Integer,List<Integer>> map = new HashMap<>();
		//定义一个List类型的变量
		//TODO在这里补足代码
        --------------------------
		return map; 
	}
```

#### 训练目标

#### 训练提示

#### 参考方案

#### 操作步骤

#### 参考答案

```java
/**
	 * 对给定的数字列表进行分组，要求返回的Map中，Key为数字，Value为该数字出现的列表。
	 * 例如，输入的数字列表为：[1,2,3,3,4,2]，
	 * 那么返回值应为：{1=[1],2=[2,2],3=[3,3],4=[4]}
	 */
	public static Map<Integer,List<Integer>> classify(Collection<Integer> numbers){
		//创建一个Map集合，用于保存需要返回的数据
		Map<Integer,List<Integer>> map = new HashMap<>();
		//定义一个List类型的变量
		List<Integer> list = null;
		//遍历参数集合，获取参数集合中每一个元素
		for (Integer integer : numbers) {
			//判断Map集合中是否已经包含这个元素做的键
			if(map.containsKey(integer)){
				//如果map集合中已经包含这个元素做的键，说明不是第一次出现，可以获取它的对应的值，也就是保存这个元素的List集合
				list = map.get(integer);
			}else{
				//如果map集合中没有包含这个元素做的键，说明是第一次出现，所以需要新建一个List集合，用来保存这个元素
				list = new ArrayList<>();
			}
			//将这个元素添加到保存它的List集合中
			list.add(integer);
			//将这个元素作为键，保存它的List集合作为值，添加到map集合中
			map.put(integer, list);
		}
		return map; 
	}
```

### 题目7（综合扩展）

需求：

1.利用键盘录入，输入一个字符串,统计该字符串中各个字符的数量

2.如用户输入字符串:"helloworld java",程序输出结果：h(1)e(1)l(3)o(2) (2)w(1)r(1)d(1)j(1)a(2)v(1)

3.注：输出结果不要求顺序一致

#### 训练目标

#### 训练提示

#### 参考方案

#### 操作步骤

1. 创建键盘输入对象

2. 使用nextLine从键盘中读取一行内容

3. 将字符串转换成字符数组

4. 创建map集合，用来存放字符：key是字符 value是字符出现的个数

5. 遍历字符数组

6. 拿到每个字符,去map中查看是否有保存对应的次数

7. 如果这个字符没有保存次数,就设置为1次
8. 如果这个字符有保存次数,就设置为原来的次数+1次 
9. 创建字符串缓冲区对象

10. 按题目要求拼接字符串

11. 输出结果

#### 参考答案

```java
/**
	 * 对给定的数字列表进行分组，要求返回的Map中，Key为数字，Value为该数字出现的列表。
	 * 例如，输入的数字列表为：[1,2,3,3,4,2]，
	 * 那么返回值应为：{1=[1],2=[2,2],3=[3,3],4=[4]}
	 */
	public static Map<Integer,List<Integer>> classify(Collection<Integer> numbers){
		//创建一个Map集合，用于保存需要返回的数据
		Map<Integer,List<Integer>> map = new HashMap<>();
		//定义一个List类型的变量
		List<Integer> list = null;
		//遍历参数集合，获取参数集合中每一个元素
		for (Integer integer : numbers) {
			//判断Map集合中是否已经包含这个元素做的键
			if(map.containsKey(integer)){
				//如果map集合中已经包含这个元素做的键，说明不是第一次出现，可以获取它的对应的值，也就是保存这个元素的List集合
				list = map.get(integer);
			}else{
				//如果map集合中没有包含这个元素做的键，说明是第一次出现，所以需要新建一个List集合，用来保存这个元素
				list = new ArrayList<>();
			}
			//将这个元素添加到保存它的List集合中
			list.add(integer);
			//将这个元素作为键，保存它的List集合作为值，添加到map集合中
			map.put(integer, list);
		}
		return map; 
	}
```

### 题目8（综合扩展）

需求：键盘录入一个字符串,分别统计出其中英文字母、空格、数字和其它字符的数量,输出结果:”其他=1, 空格=2, 字母=12,数字=6”

#### 训练目标

#### 训练提示

#### 参考方案

#### 操作步骤

#### 参考答案

```java
/*
   键盘录入一个字符串,分别统计出其中英文字母、空格、数字和其它字符的数量,输出结果:”其他=1, 空格=2, 字母=12, 数字=6”
 */
public class Test22 {
    public static void main(String[] args) {
        // 6.创建键盘录入对象
        Scanner sc = new Scanner(System.in);

        // 7.使用nextLine获取用户录入的字符串
        System.out.println("请录入一串字符串");
        String line = sc.nextLine();

        // 8.定义一个Map用于统计,字母,空格,数字和其他字符的数量,key是字符value是字符出现的次数
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        // 9.将输入的字符串转成字符
        char[] charArray = line.toCharArray();

        // 10.遍历字符串数组中的每一个字符
        for (char ch : charArray) {
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
                // 11.如果ch是一个字符,调用countingKey方法传入(map, "字母")作为参数
                countingKey(map, "字母");
            } else if (ch == ' ') {
                // 12.如果字符是一个空格,调用countingKey方法传入(map, "空格")作为参数
                countingKey(map, "空格");
            } else if (ch >= '0' && ch <= '9') {
                // 13.如果字符是一个数字,调用countingKey方法传入(map, "数字")作为参数
                countingKey(map, "数字");
            } else {
                // 14.如果字符是一个其他,调用countingKey方法传入(map, "其他")作为参数
                countingKey(map, "其他");
            }
        }
        // 15.打印统计结果
        System.out.println(map);
    }

    // 1.定义countingKey(HashMap<String, Integer> map, String key)方法.用于统计key出现的次数.调用一次,让key所对应的次数+1.
    private static void countingKey(HashMap<String, Integer> map, String key) {
        // 2.在countingKey方法中.使用get方法从map中取出key的值
        Integer num = map.get(key);
        // 3.如果为空,说明key第一次出现
        if (num == null) {
            // 4.放入key,把次数设置为1
            map.put(key, 1);
        } else {
            // 5.如果之前,已经有key了,就把key的次数+1
            map.put(key, num + 1);
        }
    }
}
```

 