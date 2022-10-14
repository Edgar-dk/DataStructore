package com.sias.linked;

import java.security.PublicKey;

/**
 * @author Edgar
 * @create 2022-10-12 13:39
 * @faction:
 */
public class Test01 {
    public static void main(String[] args) {
        HerNode heroNode1 = new HerNode(1);
        HerNode heroNode2 = new HerNode(2);
        HerNode heroNode3 = new HerNode(3);
        HerNode heroNode5 = new HerNode(5);
        Sing.addByOrder(heroNode1);
        Sing.addByOrder(heroNode2);
        Sing.addByOrder(heroNode5);
        Sing.addByOrder(heroNode3);
        HerNode f;
        HerNode gf;

        f=heroNode1;
        gf=f;
        Sing.list();
    }


}


class Sing{
    public static HerNode head = new HerNode(0);

    public static void addByOrder(HerNode herNode) {
        HerNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > herNode.no) {
                break;
            }
            if (temp.next.no == herNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("准备插入的英雄编号%d已经存在，不能加入\n", herNode.no);
        } else {
            herNode.next = temp.next;
            if (temp.no==2){
                System.out.println(temp.getClass());
                System.out.println(temp.next);
            }
            temp.next = herNode;
        }
    }

    public static void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HerNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            /*01.对象里面存储了指向下一个
             *    对象的信息，因此可以指向下一个*/
            temp = temp.next;
        }
    }
}


class HerNode {
    public int no;
    public HerNode next;
    public String name="张三";


    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public HerNode getNext() {
        return next;
    }

    public void setNext(HerNode next) {
        this.next = next;
    }



    public HerNode(int no) {
        this.no = no;
    }
    @Override
    public String toString() {
        return "F{" +
                "no=" + no +
                '}';
    }
}