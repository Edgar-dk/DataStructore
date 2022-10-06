package com.sias.queue;

import com.sun.org.apache.regexp.internal.RE;
import jdk.nashorn.internal.ir.IfNode;

/**
 * @author Edgar
 * @create 2022-10-06 21:20
 * @faction:
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {

    }
}

class ArrayQueue{
    private int MaxSize;
    private int front;
    private int rear;
    private int arr[];
    public ArrayQueue(int maxSize){
        MaxSize=maxSize;
        front=-1;//表示的是在第一个位置的前面一个
        rear=-1;//表示的是最后一个数据，没有数据的话，在第一个位置
        /*01.注意。虽然front和rear的数可能是相等的，但是二者指向的位置是不一样的*/
        arr=new int[maxSize];
    }

    /*1.判断队列是否满*/
    public boolean isFull(){
        /*01.注释下面的代码完全可以使用注释里面的代码去代替
             成功true，否则是false，return rear==MaxSize-1;*/
        if (rear==MaxSize-1){
            return false;
        }
        return true;
    }

    /*2.判断队列数据是否为空*/
    public boolean isEmpty(){
        return rear==front;
    }

    /*3.添加数据*/
    public void addQueue(int n){
        if (isFull()){
            throw new RuntimeException("里面的数据为空");
        }

        /*01.下标根据++形式自动
        *    往上面增加，数据通过外部传递进来
        *    例如外部的数据是n，可以直接放进数组中*/
        rear++;
        arr[rear]=n;
    }
}