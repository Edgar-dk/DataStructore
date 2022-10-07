package com.sias.queue;

import com.sun.org.apache.regexp.internal.RE;
import jdk.nashorn.internal.ir.IfNode;

import java.util.Scanner;

/**
 * @author Edgar
 * @create 2022-10-06 21:20
 * @faction:
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {

        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出-个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int queue1 = queue.getQueue();
                        System.out.println("取出来的数据是"+queue1);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int i = queue.headQueue();
                        System.out.println("队列头的数据是"+i);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

class ArrayQueue {
    private int MaxSize;
    private int front;
    private int rear;
    private int arr[];

    public ArrayQueue(int maxSize) {
        MaxSize = maxSize;
        front = -1;//表示的是在第一个位置的前面一个
        rear = -1;//表示的是最后一个数据，没有数据的话，在第一个位置
        /*1.front和rear的数据都是想等的，所以说位置也是在一个
         *   地方的*/
        arr = new int[maxSize];
    }

    /*1.判断队列是否满*/
    public boolean isFull() {
        /*01.注释下面的代码完全可以使用注释里面的代码去代替
             成功true，否则是false，return rear==MaxSize-1;
             MaxSize一开始的数，加入是3，最后一个索引是2，就是rear
             所以需要把MaxSize-1，才可以使二者想等*/
        return rear==MaxSize-1;
    }

    /*2.判断队列数据是否为空*/
    public boolean isEmpty() {
        return rear == front;
    }

    /*3.添加数据*/
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满，不能添加数据");
            return;
        }

        /*01.下标根据++形式自动
         *    往上面增加，数据通过外部传递进来
         *    例如外部的数据是n，可以直接放进数组中
         *    添加数据，变化的是rear，rear一开始等于-1，
         *    +1之后，就等于0，位置就在第一个数据，显然一开始的位置
         *    和front=-1的位置是一样的*/
        rear++;
        arr[rear] = n;
    }

    /*4.获取数组队列中的数据*/
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列中数据空，不能获取数据");
        }

        /*01.取出来数据，变化的是front
         *    只有一个数据的时候，数据是在索引0的位置上
         *    front在索引0前面，这个数据出来的时候，front+1，位置变成
         *    索引0位置，然后在添加数据的时候，变量会发生变化*/
        front++;
        return arr[front];
    }

    /*5.显示队列的信息*/
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空的，没有数据");
            return;
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }

    /*6.显示队列的头数据*/
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据");
        }
        return arr[front + 1];
    }
}