package org.example;

public class Main {


    public static void main(String[] args) {

        System.out.println("main is starting");
//
//        Thread1 thread1 = new Thread1("thread1");
//        //thread1.setDaemon(true);
//        thread1.start();
//
//        Thread thread2 = new Thread(() -> {
//
//            for (int i = 0; i < 5; i++) {
//
//                System.out.println("inside " + Thread.currentThread() + " , " + i);
//            }
//
//        }, "thread2");
//        thread2.start();
//
//        System.out.println("main is exiting");

//        Stack stack = new Stack(5);
//
//        new Thread(() -> {
//            int counter = 0;
//            while (++counter < 10)
//                System.out.println("Pushed: " + stack.push(100));
//        }, "Pusher").start();
//
//        new Thread(() -> {
//            int counter = 0;
//            while (++counter < 10)
//                System.out.println("Popped: " + stack.pop());
//        }, "Popper").start();
//
//
//        System.out.println("main is exiting");

//

        String lock1 = "riddhi";
        String lock2 = "dutta";

        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2) {
                    System.out.println("lock acquired");
                }
            }
        }, "thread1");

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock1) {
                    System.out.println("lock acquired");
                }
            }
        }, "thread2");

        thread1.start();
        thread2.start();

        System.out.println("main is exiting");
    }
}