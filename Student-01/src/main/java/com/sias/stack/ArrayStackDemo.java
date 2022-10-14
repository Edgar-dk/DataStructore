package com.sias.stack;

/**
 * @author Edgar
 * @create 2022-10-14 19:29
 * @faction:
 */
public class ArrayStackDemo {
}
class ArrayStack{
    private int MaxSize;
    private int[] stack;
    private int top =-1;

    public ArrayStack(int maxSize) {
        MaxSize = maxSize;
        stack=new int[maxSize];
    }
    public boolean isFull(){
        return top==MaxSize-1;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public void posh(int value){
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top]=value;
    }
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空，没有数据");
        }
        int value=stack[top];
        top--;
        return value;
    }

}
