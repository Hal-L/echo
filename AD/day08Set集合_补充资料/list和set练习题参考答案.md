# 练习题

## 知识点

List

### 题目1（加强训练）

需求：创建一个ArrayList集合，添加一些整数，然后使用不同的方式遍历这些数据。

#### 训练目标

#### 训练提示

#### 参考方案

#### 操作步骤

#### 参考答案

```java
public static void main(String[] args) {
		// 创建一个ArrayList集合
		ArrayList<Integer> list = new ArrayList<>();
		// 循环向集合中添加数据
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		// 遍历方式一：使用迭代器；
		//使用for循环
		for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
			Integer integer =  iterator.next();
			System.out.println(integer);
		}
		//while循环遍历
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			Integer integer =  iterator.next();
			System.out.println(integer);
		}
		//遍历方式二：使用普通for循环遍历
		for (int i = 0; i < list.size(); i++) {
			Integer integer =  list.get(i);
			System.out.println(integer);
		}
		//遍历方式三：使用增强for循环遍历
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
```

### 题目2（加强训练）

需求：定义一个方法int listTest(ArrayList<Integer> al, Integer s)，要求返回s在al里面第一次出现的索引，如果s没出现过返回-1。

#### 训练目标

#### 训练提示

#### 参考方案

#### 操作步骤

#### 参考答案

```java
public class CollectionTest06 {
    public static void main(String[] args) {
        //定义集合，添加数据
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(listTest(list, 5));
    }

    public static int listTest(ArrayList<Integer> al, Integer s) {
        //遍历集合，获取元素，判断元素是否与s相等，相等返回索引
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i).equals(s)) {
                return i;
            }
        }
        return -1;
    }
}
```

### 题目3（加强训练）

需求：定义一个学生类Student，包含三个属性姓名、年龄、性别，私有成员变量,生成无参，有参构造方法，生成get/set方法并重写toString()方法。创建三个学生对象存入ArrayList集合中。

1. 遍历集合遍历输出。（输出格式如：姓名：张三, 年龄：23, 性别：男）

2. 求出年龄最大的学生，然后将该对象的姓名变为：小猪佩奇。

#### 训练目标

#### 训练提示

#### 参考方案

#### 操作步骤

#### 参考答案

```java
public class CollectionTest {
    public static void main(String[] args) {
        //定义集合，向集合中添加student对象
        ArrayList<D5.DemoTostring.Student> list = new ArrayList<D5.DemoTostring.Student>();
        list.add(new D5.DemoTostring.Student("张三", 23, "男"));
        list.add(new D5.DemoTostring.Student("王五", 28, "男"));
        list.add(new D5.DemoTostring.Student("李四", 25, "男"));
        print(list);
        System.out.println("--------------");
        change(list);
        System.out.println("--------------");
        System.out.println(list);
    }
    //
    public static void change(ArrayList<D5.DemoTostring.Student> list) {
        //定义变量存放年龄
        int a = 0;
        //定义变量存放最大年龄的索引值
        int index = 0;
        //遍历集合获取年龄值，与a相比较
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAge() > a) {
                //如果年龄大于a，记录次数
                index = i;
                //并把年龄的最大值赋予a
                a = list.get(i).getAge();
            }
        }
        System.out.println("年龄最大的学生是" + list.get(index).getName());
        //将年龄最大的学生姓名变为：小猪佩奇
        list.get(index).setName("小猪佩奇");
    }
    //定义方法，遍历集合输出
    public static void print(ArrayList<D5.DemoTostring.Student> list) {
        for (D5.DemoTostring.Student student : list) {
            System.out.println(student);
        }
    }
}
```

```java
public class D5.DemoTostring.Student {
    private String name;
    private int age;
    private String sex;

    public D5.DemoTostring.Student() {
    }

    public D5.DemoTostring.Student(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return
                "姓名：" + name  +
                ", 年龄：" + age +
                ", 性别：" + sex ;
    }
}
```

### 题目4（加强训练）

需求：

1. 自定义人类:包含姓名,年龄,身高属性，私有成员变量,生成无参,有参构造方法,生成get/set方法；

2. 创建5个人放到ArrayList中；

3. 使用迭代器获取每个人的信息：找出最高的人,最矮的人，并输出最高人和最矮人的信息。

打印格式为：最高的人是张三,身高1.80；最矮的人是李四,身高1.60 。

#### 训练目标

#### 训练提示

#### 参考方案

#### 操作步骤

#### 参考答案

```java
// 1.定义学人类生成类无参,有参构造方法,生成get/set方法.
public class Person {
   private String name;
   private int age;
   private double height;

   public Person() {
   }

   public Person(String name, int age, double height) {
      this.name = name;
      this.age = age;
      this.height = height;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public double getHeight() {
      return height;
   }

   public void setHeight(double height) {
      this.height = height;
   }
}
```

```java
*
 * 自定义人类:包含姓名,年龄,身高属性.私有成员变量,生成无参,有参构造方法,生成get/set方法.
 * 创建5个人放到ArrayList中.使用迭代器获取每个人的信息.找出最高的人,最矮的人并输出最高人和最矮人的信息.
 * 打印格式如下:最高的人是张三,身高1.80. 最矮的人是李四,身高1.60
 */
public class Test22 {

   public static void main(String[] args) {
      // 2.定义ArrayList
      ArrayList<Person> persons = new ArrayList<>();

      // 3.添加5个学生
      persons.add(new Person("张三", 20, 1.66));
      persons.add(new Person("王昭君", 21, 1.65));
      persons.add(new Person("西施", 20, 1.70));
      persons.add(new Person("杨玉环", 20, 1.72));
      persons.add(new Person("凤姐", 22, 1.80));

      // 4.获取迭代器
      Iterator<Person> itr = persons.iterator();

      // 5.定义最高人
      Person maxHeightPerson = persons.get(0);
      // 6.定义最矮人
      Person minHeightPerson = persons.get(0);

      // 7.循环判断是否有下一个人
      while (itr.hasNext()) {
         // 8.使用next方法获取学生对象
         Person student = itr.next();

         // 9.判断这个人的的身高是否大于最大高度
         if (maxHeightPerson.getHeight() < student.getHeight()) {
            // 10.这个人的的身高大于最大高度.最大身高的人等于这个人
            maxHeightPerson = student;
         } else if (minHeightPerson.getHeight() > student.getHeight()) {
            // 11.判断这个人的的身高是否小于于最矮高度
            // 12.这个人的的身高小于于最矮高度.最矮身高的人等于这个人
            minHeightPerson = student;
         }
      }
       // 13.按照格式打印信息
      System.out.println("最高的人是" + maxHeightPerson.getName() + ",身高 " + maxHeightPerson.getHeight() + ". 最矮的人是"
            + minHeightPerson.getName() + ",身高 " + minHeightPerson.getHeight());
   }
}
```

### 题目5（加强训练）

需求：

1. 有如下一个数据操作接口IDataOperation<E>和一个学生类Student，现需要提供一个IDataOperation接口的实现类，用来对学生信息进行操作；

2. 在IDataOperation接口实现类中，使用集合保存学生信息；

3. 注意：学生信息包括学号、姓名、年龄和地址；其中，学生的学号是唯一的，不能出现两个学号一样的学生。

   ```java
   //数据操作接口
   interface IDataOperation<E> {
   	// 添加数据
   	public boolean add(E t);
   	// 根据唯一标识删除一个数据
   	public <T> boolean delete(T t);
   	// 修改一个数据
   	public <T> boolean update(E e);
   	// 根据唯一表示查找一个数据
   	public <T> E get(T t);
   	// 查找所有数据
   	public Collection<E> getAll();
   }
   ```

   ```java
   // 标准学生类
   class D5.DemoTostring.Student {
   	private String id;// 学号
   	private String name;// 姓名
   	private String age;// 年龄
   	private String address;// 居住地
   	public D5.DemoTostring.Student() {}
   	public D5.DemoTostring.Student(String id, String name, String age, String address) {
   		this.id = id;
   		this.name = name;
   		this.age = age;
   		this.address = address;
   	}
   	public String getId() {
   		return id;
   	}
   	public void setId(String id) {
   		this.id = id;
   	}
   	public String getName() {
   		return name;
   	}
   	public void setName(String name) {
   		this.name = name;
   	}
   	public String getAge() {
   		return age;
   	}
   	public void setAge(String age) {
   		this.age = age;
   	}
   	public String getAddress() {
   		return address;
   	}
   	public void setAddress(String address) {
   		this.address = address;
   	}
   	@Override
   	public String toString() {
   		return "D5.DemoTostring.Student [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + "]";
   	}
   }
   ```

#### 训练目标

#### 训练提示

#### 参考方案

#### 操作步骤

#### 参考答案

   ```java
   class IDataOperationImpl implements IDataOperation<D5.DemoTostring.Student>{
   	//因为要使用集合保存数据，所以先要创建一个集合容器
   	private Collection<D5.DemoTostring.Student> c = new ArrayList<>();
   	// 添加数据
   	public boolean add(D5.DemoTostring.Student t) {
   		//因为不能出现两个一样学号的学生，所以再保存之前先根据学号查找学生信息。
   		//如果找到了，就不保存，同时返回false
   		D5.DemoTostring.Student stu = get(t.getId());
   		if(stu != null){
   			System.out.println("已存在该学号的学生信息，不能重复添加！");
   			return false;
   		}else{
   			//不存在该学号的学生信息，就添加学生，同时返回true
   			c.add(t);
   			return true;
   		}
   	}
   	// 根据唯一标识删除一个数据
   	public <T> boolean delete(T t) {
   		D5.DemoTostring.Student stu = get(t);
   		if(stu == null){
   			System.out.println("没有这个学生信息！");
   			return false;
   		}else{
   			return c.remove(stu);
   		}
   	}
   	// 修改一个数据
   	public boolean update(D5.DemoTostring.Student e) {
   		//要修改数据，需要先查找数据。因为学生的唯一标识是学号，所以先根据学号找到学生信息；
   		D5.DemoTostring.Student stu = get(e.getId());
   		if(stu == null){
   			System.out.println("没有这个学生信息！");
   			return false;
   		}else{
   			stu.setAddress(e.getAddress());
   			stu.setAge(e.getAge());
   			stu.setName(e.getName());
   			return true;
   		}
   	}
   	// 根据唯一标识查找一个数据
   	public <T> D5.DemoTostring.Student get(T t) {
   		if(c.isEmpty()){
   			System.out.println("还没有学生信息！");
   		}else{
   			for (D5.DemoTostring.Student student : c) {
   				if(t.equals(student.getId())){
   					return student;
   				}
   			}
   		}
   		return null;
   	}
   	// 查找所有数据
   	public Collection<D5.DemoTostring.Student> getAll() {
   		return c;
   	}
   }
   ```

### 题目6（综合扩展）

需求：创建一个类，提供一个功能，向LinkedList集合中添加自定义的Person类对象；要求：

1. Person应该具有姓名、性别和年龄三个属性；

2. 添加对象时，如果容器中已存在该对象，就不添加；（要求：不能使用集合提供的contains方法）

3. 如果Person对象的姓名和性别相同，就认为是同一个人；

#### 训练目标

#### 训练提示

#### 参考方案

#### 操作步骤

#### 参考答案

```java
//标准Person类
class Person{
	private String name;//姓名
	private int age;//年龄
	private String gender;//性别
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Person(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public Person() {}
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	//因为要求只要性别相同，就认为是同一个人，所以重写hashCode和equals方法时只需要考虑姓名和性别两个属性
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
```

```java
class Test22 {// 测试类
	public static void add(LinkedList<Person> list, Person p){
		for (Person person : list) {
			if(person.equals(p)){
				return;
			}
		}
		list.add(p);
	}
	public static void main(String[] args) {
		LinkedList<Person> list = new LinkedList<>();
		add(list,new Person("小红",20,"女"));
		add(list,new Person("小明",20,"男"));
		add(list,new Person("小明",20,"男"));
		add(list,new Person("小红",20,"女"));
		System.out.println(list);
	}
}
```

### 题目7（综合扩展）

需求：使用ArrayList集合，模拟实现一个栈；要求：

1. 提供入队、出队和获取队列长度的功能；

#### 训练目标

#### 训练提示

#### 参考方案

#### 操作步骤

#### 参考答案

```java
//模拟栈
class MyStack<T>{
	ArrayList<T> list = new ArrayList<>();
	//入队
	public void add(T t){
		list.add(t);
	}
	//出队
	public T remove(){
		//因为队列具有先进后出的特点，而向ArrayList集合中添加数据是有序的，
		//所以移除数据时需要移除最后一个下标上的数据
		return list.remove(list.size()-1);
	}
	//获取队列长度
	public int size(){
		return list.size();
	}
}
```

```java
class Test22 {// 测试类
	public static void main(String[] args) {
		MyStack<String> mq = new MyStack<>();
		mq.add("111");
		mq.add("222");
		mq.add("333");
		while(mq.size() > 0){
			System.out.println(mq.remove());
		}
	}
}
```

## 知识点

Set

### 题目1（加强训练）

需求：ArrayList有以下元素: "a","f","b","c","a","d"利用HashSet对ArrayList集合去重(最终结果: ArrayList中没有重复元素)。

#### 训练目标

#### 训练提示

#### 参考方案

#### 操作步骤

1. 创建ArrayList
2. 使用add方法往ArrayList添加元素
3. 创建HashSet.用于将ArrayList中重复的元素去除
4. 调用HashSet的addAll方法,将ArrayList中的元素添加到HashSet中
5. 清空list的所有元素
6. 将set集合中的元素再添加回ArrayList集合

#### 参考答案

```java
/*
 * ArrayList有以下元素: "a","f","b","c","a","d"
 * 利用HashSet对ArrayList集合去重(最终结果: ArrayList中没有重复元素)
 */
public class Test22 {
    public static void main(String[] args) {
        // 1.创建ArrayList
        ArrayList<String> list = new ArrayList<>();

        // 2.使用add方法往ArrayList添加元素
        list.add("a");
        list.add("f");
        list.add("b");
        list.add("c");
        list.add("a");
        list.add("d");

        // 3.创建HashSet.用于将ArrayList中重复的元素去除
        HashSet<String> set = new HashSet<>();

        // 4.调用HashSet的addAll方法,将ArrayList中的元素添加到HashSet中
        for (String s : list) {
            set.add(s);
        }

        // 5.清空list的所有元素
        list.clear();

        // 6.将set集合中的元素再添加回ArrayList集合
        list.addAll(set);
        System.out.println(list);
    }
}
```

### 题目2（加强训练）

需求：双色球规则，双色球每注投注号码由6个红色球号码和1个蓝色球号码组成。红色球号码从1—33中选择，红球不可重复；蓝色球号码从1—16中选择。请随机生成一注双色球号码。

#### 训练目标

#### 训练提示

#### 参考方案

#### 操作步骤

#### 参考答案

```java
import java.util.HashSet;
import java.util.Random;

/*
 * 双色球规则:双色球每注投注号码由6个红色球号码和1个蓝色球号码组成。
 * 红色球号码从1—33中选择；蓝色球号码从1—16中选择.请随机生成一注双色球号码
 * */
public class Test22 {
    public static void main(String[] args) {
        // 1.创建Random随机数对象
        Random ran = new Random();

        // 2.创建HashSet用于保存不重复的红球
        HashSet<Integer> hs = new HashSet<>();

        // 3.循环判断红球数量是否小于6个
        while (hs.size() < 6) {
            // 4.球数量小于6个就产生一个红球.添加到HashSet中
            int num = ran.nextInt(33) + 1;
            hs.add(num);
        }

        // 5.在生成一个红球
        int blueBall = ran.nextInt(16) + 1;

        // 6.打印中奖号码
        System.out.println("双色球中奖号码:");
        System.out.print("红球是: ");

        for (Integer redBall : hs) {
            System.out.print(redBall + " ");
        }

        System.out.println();
        System.out.println("蓝球是: " + blueBall);
    }
}
```

### 题目3（加强训练）

需求：使用HashSet集合，保存自定义的Person类对象；要求：

1. Person应该具有姓名、性别和年龄三个属性；
2. 如果Person对象的姓名和性别相同，就认为是同一个人；

#### 训练目标

#### 训练提示

#### 参考方案

#### 操作步骤

#### 参考答案

```java
//标准Person类
class Person{
	private String name;//姓名
	private int age;//年龄
	private String gender;//性别
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Person(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public Person() {}
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	//因为要求只要姓名和性别相同，就认为是同一个人，所以重写hashCode和equals方法时只需要考虑姓名和性别两个属性
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
```

```java
class Test22 {// 测试类
	public static void main(String[] args) {
		HashSet<Person> hs = new HashSet<>();
		hs.add(new Person("小红",20,"女"));
		hs.add(new Person("小明",20,"男"));
		hs.add(new Person("小明",23,"男"));
		System.out.println(hs);
	}
}
```

### 题目4（加强训练）

需求:使用LinkedHashSet集合，保存自定义的Student类对象；要求：

1. Student应该具有姓名、性别、年龄和学号四个属性；
2. 如果Student对象的学号相同，就认为是同一个人；

#### 训练目标

#### 训练提示

#### 参考方案

#### 操作步骤

#### 参考答案

```java
//标准Student类
class D5.DemoTostring.Student{
	private int num;//学号
	private String name;//姓名
	private String gender;//性别
	private int age;//年龄
	public D5.DemoTostring.Student() {}
	public D5.DemoTostring.Student(int num, String name, int age, String gender) {
		this.num = num;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "D5.DemoTostring.Student [num=" + num + ", name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}
	//因为要求只要学号相同，就认为是同一个人，所以重写hashCode和equals方法时只需要考虑学号这个属性
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		D5.DemoTostring.Student other = (D5.DemoTostring.Student) obj;
		if (num != other.num)
			return false;
		return true;
	}
}
```

```java
class Test22 {// 测试类
	public static void main(String[] args) {
		LinkedHashSet<D5.DemoTostring.Student> hs = new LinkedHashSet<>();
		hs.add(new D5.DemoTostring.Student(100,"小红",20,"女"));
		hs.add(new D5.DemoTostring.Student(100,"小明",20,"男"));
		hs.add(new D5.DemoTostring.Student(101,"小明",23,"男"));
		System.out.println(hs);
	}
```

 