package KnowledgePoints.Fu_Zi.demo13;

public class Keyboard implements USB{
    @Override
    public void open() {
        System.out.println("开启键盘,绿光闪一闪");
    }

    @Override
    public void close() {
        System.out.println("关闭键盘,绿光熄灭");
    }

    public void type(){
        System.out.println("敲击键盘");
    }

}
