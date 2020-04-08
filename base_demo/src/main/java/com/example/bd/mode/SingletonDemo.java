package com.example.bd.mode;

import java.lang.reflect.Constructor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: yl Created by IntelliJ IDEA
 * DateTime: 2020/3/26 11:30
 * version:
 * description:
 */
public class SingletonDemo {
    public static void main(String[] args) {
        test1();
        test2();
//        test3();
//        test4();
//        test5();
        test6();
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test7();
        test8();
        test9();
    }

    private static void test1() {
        System.out.println("==============饿汉式==============");
        Student1 student11 = Student1.getInstance();
        Student1 student12 = Student1.getInstance();
        System.out.println(student11.equals(student12));
    }

    private static void test2() {
        System.out.println("==============懒汉式==============");
        Student2 student21 = Student2.getInstance();
        Student2 student22 = Student2.getInstance();
        System.out.println(student21.equals(student22));
    }

    private static void test3() {
        System.out.println("==============懒汉式（模拟线程不安全）==============");
        new Thread(() -> {
            Student3 student31 = Student3.getInstance();
            System.out.println("student31：" + student31);
        }).start();

        new Thread(() -> {
            Student3 student32 = Student3.getInstance();
            System.out.println("student32：" + student32);
        }).start();
    }

    private static void test4() {
        System.out.println("==============懒汉式（模拟线程安全）==============");
        new Thread(() -> {
            Student4 student41 = Student4.getInstance();
            System.out.println("student41：" + student41);
        }).start();

        new Thread(() -> {
            Student4 student42 = Student4.getInstance();
            System.out.println("student42：" + student42);
        }).start();
    }

    private static void test5() {
        System.out.println("==============懒汉式（模拟线程安全）==============");
        new Thread(() -> {
            Student5 student51 = Student5.getInstance();
            System.out.println("student51：" + student51);
        }).start();

        new Thread(() -> {
            Student5 student52 = Student5.getInstance();
            System.out.println("student52：" + student52);
        }).start();
    }

    private static void test6() {
        System.out.println("==============懒汉式（模拟线程安全）==============");
        new Thread(() -> {
            Student6 student61 = Student6.getInstance();
            System.out.println("student61：" + student61);
        }).start();

        new Thread(() -> {
            Student6 student62 = Student6.getInstance();
            System.out.println("student62：" + student62);
        }).start();
    }

    private static void test7() {
        System.out.println("==============静态内部类==============");
        Student7 student71 = Student7.getInstance();
        Student7 student72 = Student7.getInstance();
        System.out.println(student71.equals(student72));
    }

    private static void test8() {
        System.out.println("==============反射破坏单例==============");
        try {
            Constructor<Student7> declaredConstructor = Student7.class.getDeclaredConstructor(null);
            // 暴力访问
            declaredConstructor.setAccessible(true);
            Student7 student71 = declaredConstructor.newInstance();
            Student7 student72 = declaredConstructor.newInstance();
            System.out.println("student71：" + student71);
            System.out.println("student72：" + student72);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test9() {
        System.out.println("==============反射破坏单例==============");
        try {
            Constructor<Student9> declaredConstructor = Student9.class.getDeclaredConstructor(null);
            // 暴力访问
            declaredConstructor.setAccessible(true);
            Student9 student91 = declaredConstructor.newInstance();
            Student9 student92 = declaredConstructor.newInstance();
            System.out.println("student91：" + student91);
            System.out.println("student92：" + student92);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 * 饿汗式，通过static变量，也就是类加载原理保证单例，也就是所谓的线程安全。没有实现懒加载
 */
class Student1 {

    // 1、私有化构造方法
    private Student1() {
    }

    // 2、静态初始化对象
    private static Student1 student1 = new Student1();

    // 3、通过静态方法返回对象
    public static Student1 getInstance() {
        return student1;
    }
}

/**
 * 懒汗式，线程不安全
 */
class Student2 {
    private static Student2 student2 = null;

    private Student2() {
    }

    public static Student2 getInstance() {
        if (student2 == null) {
            student2 = new Student2();
        }
        return student2;
    }
}

class Student3 {
    private static Student3 student3 = null;

    private Student3() {
    }

    public static Student3 getInstance() {
        if (student3 == null) {
            /*休眠，模拟延时*/
            try {
                TimeUnit.MILLISECONDS.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            student3 = new Student3();
        }
        return student3;
    }
}

/**
 * 虽说能保证线程安全，但是，效率太低
 */
class Student4 {
    private static Student4 student4 = null;

    private Student4() {
    }

    public synchronized static Student4 getInstance() {
        if (student4 == null) {
            /*休眠，模拟延时*/
            try {
                TimeUnit.MILLISECONDS.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            student4 = new Student4();
        }
        return student4;
    }
}

/**
 * 虽说能保证线程安全，保证效率，但是线程不安全
 */
class Student5 {
    private static Student5 student5 = null;

    private Student5() {
    }

    public static Student5 getInstance() {
        if (student5 == null) {
            synchronized (Student5.class) {
                student5 = new Student5();
            }
        }
        return student5;
    }
}

/**
 * 虽说能保证线程安全，保证效率、线程安全
 */
class Student6 {
    private static Student6 student6 = null;

    private Student6() {
    }

    public static Student6 getInstance() {
        if (student6 == null) {
            synchronized (Student5.class) {
                if (student6 == null) {
                    student6 = new Student6();
                }
            }
        }
        return student6;
    }
}

/**
 * 静态内部类
 */
class Student7 {

    private Student7() {
    }

    private static class Instance {
        private final static Student7 STUDENT_7 = new Student7();
    }

    public static Student7 getInstance() {
        return Instance.STUDENT_7;
    }
}

class Student9 {

    private Student9() {
        synchronized (Student9.class) {
            if (Instance.STUDENT_9 == null) {
                try {
                    throw new Exception("该对象已实例化,不要试图破解!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Instance {
        private final static Student9 STUDENT_9 = new Student9();
    }

    public static Student9 getInstance() {
        return Instance.STUDENT_9;
    }
}