package com.example.gxy.demo.thread;

/**
 * @author GXY
 * @Package com.example.gxy.demo.thread
 * @date 2020/10/17 17:24
 * @Copyright © 2020-2021 新流通
 * @Description:
 */
public class JoinTest01 {
    public static void main(String[] args) {
        final Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1");
            }
        });

        final Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 引用t1线程，等待t1线程执行完
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2");
            }
        });

        final Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 引用t2线程，等待t2线程执行完
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t3");
            }
        });

        t2.start();;
        t3.start();
        t1.start();

    }
}
