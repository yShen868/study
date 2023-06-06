package com.lagou.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class proxyTest {
//    public static void main(String[] args) {
//
//        System.out.println("不使用代理类，调用doSomething");
//        Person person = new Bob();
//        person.doSomething();
//
//        System.out.println("--------------------------");
//
//        System.out.println("使用代理类，调用doSomething");
//        Person proxy = (Person) new JDKDynamicProxy(new Bob()).getTarget();
//        proxy.doSomething();
//
//
//
//    }
    public static void main(String[] args) {

//        System.out.println("不使用代理类，调用doSomething");
        Person person = new Bob();
//        person.doSomething();
//
//        System.out.println("--------------------------");
//
//        System.out.println("使用代理类，调用doSomething");
//        Person proxy = (Person) new JDKDynamicProxy(new Bob()).getTarget();
//        proxy.doSomething();


        Person o = (Person) Proxy.newProxyInstance(Bob.class.getClassLoader(),
                new Class[]{Person.class}, new InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        Object invoke = method.invoke(person, args);
//                        System.out.println("invoke:{}"+invoke);
//                        return invoke;
                        System.out.println("对原方法进行了前置增强");
                        //原方法执行
                        Object invoke = method.invoke(person, args);
                        System.out.println(invoke);
                        System.out.println("对原方法进行了后置增强");
//                        return invoke;
                        return "hello";
                    }
                });


        String haha = o.haha();
        System.out.println("结果"+haha);

    }
}
