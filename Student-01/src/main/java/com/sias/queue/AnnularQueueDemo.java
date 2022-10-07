package com.sias.queue;

import java.util.Scanner;

/**
 * @author Edgar
 * @create 2022-10-07 18:26
 * @faction:
 */
public class AnnularQueueDemo {
    public static void main(String[] args) {
        AnnularQueue queue = new AnnularQueue(4);
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

class AnnularQueue {
    private int MaxSize;
    private int front;
    private int rear;
    private int arr [];

    /*1.假如说可以数组大小是4个，实际存放的数据其实是3个
    *   front在最前面，rear在最后一个数据的后面一个位置上
    *   实际存放的值，比数组长度小一个，其他的计算公式都是可以计算出来的*/
    public AnnularQueue(int maxSize){
        MaxSize=maxSize;
        arr=new int[maxSize];
    }

    /*2.判断队列数据是否满
    *   rear在第一个位置也可以判断出是否满了，在第二个
    *   也是可以判断出来的*/
    public boolean isFull(){
        return (rear+1)%MaxSize==front;
    }

    /*3.判断是否为空
    *   初始位置的时候，front和rear的位置
    *   都在第一个位置上，进来一个数据，front不动，一直
    *   指向第一个位置上的数据，rear向后面移动一个，指向最后一个数据
    *   后面的位置*/
    public boolean isEmpty(){
        return rear==front;
    }

    /*4.添加数据到队列*/
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列数据已经满了");
            return;
        }
        arr[rear]=n;
        rear=(rear+1)%MaxSize;
    }

    /*5.获取队列的数据（从第一个开始）*/
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空，不能取数据");
        }
        int value = arr[front];
        front=(front+1)%MaxSize;
        return value;
    }
    /*6.显示队列的数据*/
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列是空的，没有数据");
            return;
        }

        for (int i=front;i<front+size();i++){
            System.out.println(arr[i%MaxSize]);
        }
        /*for (int i : arr) {
            System.out.println(i);
        }*/
    }

    /*7.队列中有效数据个数*/
    public int size(){
        return (rear+MaxSize-front)%MaxSize;
    }
    /*8.显示队列的头数据*/
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空，不能取数据");
        }
        return arr[front];
    }
}