package KnowledgePoints.permission.test2;


import KnowledgePoints.permission.test1.Fu;

public class Test {
    public static void main(String[] args) {
        // 不同包下, 被无关类访问
        Fu f = new Fu();
        //f.show();
        //f.print();
    }
}
