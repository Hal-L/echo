package KnowledgePoints.permission.test2;


import KnowledgePoints.permission.test1.Fu;

public class Son extends Fu {
     // 不同包下, 被子类访问
     public void method(){
         // super.show();
         super.print();
     }
}
