package KnowledgePoints.DuoTai.DuoTaiTest;

class DynamicTest {
    public static void main(String[] args) {

        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();

        System.out.println(a1.show(b));
        System.out.println(a1.show(c));//A A
        System.out.println(a1.show(d));//A  D

        System.out.println(a2.show(b));//B A

        System.out.println(a2.show(c));//B A

        System.out.println(a2.show(d));//A D

        System.out.println(b.show(b));//B B

        System.out.println(b.show(c));//B B

        System.out.println(b.show(d));//A D

    }
}