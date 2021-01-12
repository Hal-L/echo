package KnowledgePoints.mEnum.test;

public @interface Anno01 {
    int show01() default 1;

    String show02() default "abc";

    Light show03() default Light.GREEN;

    Anno02 show04() default @Anno02;

    String[] value();



}
