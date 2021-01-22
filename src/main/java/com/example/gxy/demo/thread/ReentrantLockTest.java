package com.example.gxy.demo.thread;

import com.sun.prism.shader.FillEllipse_LinearGradient_PAD_Loader;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author GXY
 * @Package com.example.gxy.demo.thread
 * @date 2020/10/19 15:06
 * @Copyright © 2020-2021 新流通
 * @Description:该demo模拟电影院的售票情况,tickets总票数。开启了10个窗口售票，售完为止
 * https://blog.csdn.net/u014730165/article/details/82144848
 */
public class ReentrantLockTest implements Runnable{

    private ReentrantLock  lock = new ReentrantLock();
    private int tickets = 200;

    @Override
    public void run() {
        while (true) {
            lock.lock();
            System.out.println("正在等待锁的线程数："+ lock.getQueueLength());
            try {
                if (tickets > 0){
                    TimeUnit.MILLISECONDS.sleep(100);
                    System.out.println(Thread.currentThread().getName()+" 剩余票数："+tickets--);
                }else {
                    break;
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLockTest lockTest = new ReentrantLockTest();
        for (int i = 0; i <10; i++) {
            Thread thread = new Thread(lockTest,"thread" + i);
            thread.start();
        }
    }


}
