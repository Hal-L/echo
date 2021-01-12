package KnowledgePoints.Fu_Zi.demo13;

public class Mouse implements USB {
    @Override
    public void open() {
        System.out.println("启动鼠标,红灯闪一闪");
    }

    @Override
    public void close() {
        System.out.println("关闭鼠标,红灯熄灭");
    }

    public void click(){
        System.out.println("点击鼠标~~~");
    }
}
