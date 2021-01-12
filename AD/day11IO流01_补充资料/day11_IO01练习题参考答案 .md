## 练习题

### 第一题

+ 要求

  定义测试类，在测试类中定义main()方法，按以下要求编写代码：

  ​ 构造一个File对象，指向项目根目录下的demo03.txt（此文件不存在）；

  ​ 判断，如果文件不存在，就创建这个文件，打印创建结果；

  ​ 判断这个File对象是否是一个文件，打印结果；

  ​ 判断这个File对象是否是一个目录，打印结果；

  ​ 删除这个文件

+ 参考代码

  ```java
  import java.io.File;
  import java.io.IOException;
  public class Test001 {
  	/*
  	 * 定义测试类，在测试类中定义main()方法，按以下要求编写代码：
  		构造一个File对象，指向项目根目录下的demo03.txt（此文件不存在）；
  		判断，如果文件不存在，就创建这个文件，打印创建结果；
  		判断这个File对象是否是一个文件，打印结果；
  		判断这个File对象是否是一个目录，打印结果；
  		删除这个文件；
  	 */
  	public static void main(String[] args) throws IOException {
  		File file = new File("demo03.txt");
  		if(! file.exists()){
  			file.createNewFile();
  		}
  		if(file.isFile()){
  			System.out.println("是一个文件");
  		}else{
  			System.out.println("不是一个文件");
  		}
  		if(file.isDirectory()){
  			System.out.println("是一个目录");
  		}else {
  			System.out.println("不是一个目录");
  		}
  	}
  }
  ```

### 第二题

+ 要求

  定义类，定义main()方法，按以下要求编写代码：

  ​ 构造一个File对象，指向你D盘的某个目录；​

  ​ 获取此目录下所有的文件/目录的File对象，遍历这个数组，获取每个File对象

  ​ 判断：如果是文件，打印：”文件(绝对路径)” 否则，打印：”目录(绝对路径)

+ 参考代码

  ```java
  import java.io.File;
  public class Test005 {
  	/*
  	 * 定义类，定义main()方法，按以下要求编写代码：
  		构造一个File对象，指向你D盘的某个目录；
  		获取此目录下所有的文件/目录的名称，并打印。(list())
  		获取此目录下所有的文件/目录的File对象，遍历这个数组，获取每个File对象，
  		判断：如果是文件，打印：”文件(绝对路径)” 否则，打印：”目录(绝对路径)”
  	 */	
  	public static void main(String[] args) {
  		File file = new File("D:\\kaifa");
  		//获取此目录下所有的文件/目录的File对象
  		File[] listFiles = file.listFiles();
  		for (File file2 : listFiles) {
  			if(file2.isDirectory()){
  				System.out.println("这个是目录");
  				System.out.println(file2.getPath());
  			}else{
  				System.out.println("这是一个文件");
  				System.out.println(file2.getAbsolutePath());
  			}
  		}
  	}
  }
  ```

  ​

### 第三题

+ 要求

  使用字节流，将一个路径下的视频复制到另一路径下

+ 参考代码

  ```java
  public class CopyVideo {
  	public static void main(String[] args) throws IOException {
  		method("D:\\video01.avi", "D:\\video02.avi");
  		
  	}
  	//字节流，一次可以一个字节一个字节的读写，但是效率太低，因此在这一次一个字节数组
  	public static void method(String srcPath, String destPath) throws IOException {
  		FileInputStream fis = new FileInputStream(srcPath);
  		FileOutputStream fos = new FileOutputStream(destPath);
  		//读取数据
  		byte[] buffer = new byte[1024];
  		int len  = 0;
  		while( (len=fis.read(buffer)) != -1){
  			//写数据到目的地
  			fos.write(buffer, 0, len);
  		}
  		fos.close();
  		fis.close();
  	}
  }
  ```

  ​

