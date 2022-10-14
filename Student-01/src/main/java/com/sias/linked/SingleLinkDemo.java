package com.sias.linked;

import java.util.Stack;

/**
 * @author Edgar
 * @create 2022-10-08 19:54
 * @faction:
 */
public class SingleLinkDemo {

    private static SingleLink singleLink;

    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "林冲", "豹子头");
        HeroNode heroNode3 = new HeroNode(3, "武大郎", "烧饼");
        HeroNode heroNode5 = new HeroNode(5, "武二郎", "壮");
        singleLink = new SingleLink();
        /*1.插入数据*/
        singleLink.add(heroNode1);
        singleLink.add(heroNode2);
        singleLink.add(heroNode5);
        singleLink.add(heroNode3);
        /*2.展示数据*/
        singleLink.list();

        /*3.修改数据*/
        /*HeroNode heroNode5Update = new HeroNode(5, "武二郎-", "小壮");
        singleLink.update(heroNode5Update);
        System.out.println("修改后节点的信息");
        singleLink.list();*/

        /*4.删除数据*/
       /* singleLink.delete(5);
        System.out.println("删除后的节点信息");
        singleLink.list();*/
        System.out.println();
        /*5.获取节点的个数*/
        System.out.println(getLength(SingleLink.head));
        /*6.得到倒数第K个节点*/
        System.out.println(getLastNode(SingleLink.head, 2));

        System.out.println();
        /*7.反转节点*/
        reversetList(SingleLink.head);
        singleLink.list();

        System.out.println("逆序打印链表");

        reversePrint(SingleLink.head);

    }

    /*1.统计一个链表中有效数据的个数，不算头节点*/
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode cur = head;
        while (cur.next != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    /*2.找到倒数第K个节点*/
    public static HeroNode getLastNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
        int size = getLength(head);
        if (index <= 0 || index > size) {
            return null;
        }
        HeroNode temp = head.next;
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /*3.链表反转*/
    public static void reversetList(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode cur = head.next;
        /*1.用于指向cur后面那个，防止第一个断裂之后，后面的链表找不到了*/
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        while (cur != null) {
            /*1.把第二个先放在一个next的引用
             *   类型变量里面*/
            next = cur.next;
            /*2.然后在把第一个的next赋值为空，*/
            cur.next = reverseHead.next;
            /*3.在把第一个放在reverseHead的后面*/
            reverseHead.next = cur;
            /*4.然后cur在等于next指向下一个*/
            cur = next;
        }
        head.next = reverseHead.next;
    }

    /*4.逆序打印链表*/
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
//            System.out.println("链表里面没有数据");
            return;
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }

    }

}

class SingleLink {

    /*1.头节点信息*/
    public static HeroNode head = new HeroNode(0, "", "");

    /*2.添加信息
     *   添加信息就是把对象
     *   传入进去，然后另外一个地址，指向这个，*/
    public void add(HeroNode heroNode) {
        /*01，在去创建一个变量，指向这个头节点
         *     然后去辅助遍历链表，从而可以更好的
         *    找到数据，下面的方式利用了多个变量指向
         *    同一个堆空间地址的方式，*/
        HeroNode temp = head;

        /*02.遍历整个链表，找到最后一个节点信息
         *    为null的*/
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }

        temp.setNext(heroNode);
    }

    /*3.显示链表里面的信息*/
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
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

    /*4.按照顺序排序
     *   插入数据也可以*/
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            }
            if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            /*01.只要是不满足条件的，就往下面执行，把temp指向下一个节点对象*/
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("准备插入的英雄编号%d已经存在，不能加入\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    /*5.修改节点的信息*/
    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.println("没有找到想要修改的节点");
        }
    }

    /*6.删除节点信息*/
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            /*01.修改了地址的指向，没有被引用的对象
             *    就会被删除*/
            temp.next = temp.next.next;
        } else {
            System.out.println("链表到最后，没有要找到要删除的数据");
        }
    }
}


/*1.一个HeroNode就是一个节点
 *   一个节点上存放的是一个英雄的基本信息*/
class HeroNode {
    public int no;
    public String name;
    public String nickname;//昵称
    public HeroNode next;


    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}