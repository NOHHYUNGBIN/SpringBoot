package com.core.springpractice.aop;

import java.lang.reflect.Method;

public class AopMain {
    public static void main(String[] args) throws Exception {
        Class myClass = Class.forName("com.core.springpractice.aop.MyClass");
        Object obj = myClass.newInstance();

        MyAdvice myAdvice = new MyAdvice();

        for(Method m : myClass.getDeclaredMethods()) {
            myAdvice.invoke(m,obj, null);
        }
    }

}
class MyAdvice {
    void invoke(Method m, Object obj, Object ...args)throws Exception  {
        System.out.println("[before] {");
        m.invoke(obj,args);
        System.out.println("} [after]");
    }
}
class MyClass {
    void aaa() {
        System.out.println("aaa");
    }
    void bbb() {
        System.out.println("aaa");
    }
    void ccc() {
        System.out.println("aaa");
    }
}
