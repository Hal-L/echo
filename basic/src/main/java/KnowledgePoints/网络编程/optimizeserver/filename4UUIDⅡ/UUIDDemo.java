package KnowledgePoints.网络编程.optimizeserver.filename4UUIDⅡ;

import java.util.UUID;

public class UUIDDemo {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString().replace("-","");
        System.out.println(s);
    }
}
