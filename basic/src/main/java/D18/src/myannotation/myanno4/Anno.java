package myannotation.myanno4;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD})
// Target指定注解使用的位置（成员变量(FIELD)，类(TYPE)，方法(METHOD)）
@Retention(RetentionPolicy.RUNTIME) //指定该注解的存活时间,(RUNTIME运行时)
//@Inherited //指定该注解可以被继承
public @interface Anno {
}
