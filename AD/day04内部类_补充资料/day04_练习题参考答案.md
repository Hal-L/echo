## 练习题

### 第一题

+ 要求

  补全代码,运行后控制台打印 HelloWorld

  ```java
  interface Inter{
  	void show();
  }
  class Outer{
  	//补全代码
  }
  class OuterDemo{
  	public static void main(String[] args) {
  		Outer.method().show(); // HelloWorld
  	}
  }
  ```

+ 参考代码

  ```java
  interface Inter{
  	void show();
  }
  class Outer{
  	//补全代码
      // 通过类名调用,说明method是一个静态方法
      // 调用method之后可以直接调用show方法,说明method方法的返回值是Inter类型
    	public static Inter method(){
  		return new Inter(){
  			@Override
  			public void show() {
  				System.out.println("HelloWorld");
  			}
  		};
  	}
  }
  class OuterDemo{
  	public static void main(String[] args) {
  		Outer.method().show(); // HelloWorld
  	}
  }
  ```

### 第二题

+ 要求

  使用Lambda表达式标准格式对补全的代码进行优化

+ 参考代码

  ```java
  interface Inter{
  	void show();
  }
  class Outer{
  	//补全代码
    	public static Inter method(){
  		/*return new Inter(){
              @Override
              public void show() {
                  System.out.println("HelloWorld");
              }
          };*/
        
          // 使用Lambda表达式标准格式进行优化
          return () -> {
              System.out.println("HelloWorld");
          };
  	}
  }
  class OuterDemo{
  	public static void main(String[] args) {
  		Outer.method().show(); // HelloWorld
  	}
  }
  ```

### 第三题

+ 要求

  使用Lambda表达式的省略格式对补全的代码进行优化

+ 参考代码

  ```java
  interface Inter{
  	void show();
  }
  class Outer{
  	//补全代码
    	public static Inter method(){
  		/*return new Inter(){
              @Override
              public void show() {
                  System.out.println("HelloWorld");
              }
          };*/
        
          /*// 使用Lambda表达式进行优化
          return () -> {
              System.out.println("HelloWorld");
          };*/
        
          // 使用Lambda表达式省略格式进行优化
          return () -> System.out.println("HelloWorld");
  	}
  }
  class OuterDemo{
  	public static void main(String[] args) {
  		Outer.method().show(); // HelloWorld
  	}
  }
  ```

  ​