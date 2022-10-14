package com.sias.linked;

/**
 * @author Edgar
 * @create 2022-10-11 19:16
 * @faction:
 */
public class DoubleLinkDemo {
    public static void main(String[] args) {
        HeroNode2 heroNode1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 heroNode2 = new HeroNode2(2, "林冲", "豹子头");
        HeroNode2 heroNode3 = new HeroNode2(3, "武大郎", "烧饼");
        HeroNode2 heroNode5 = new HeroNode2(5, "武二郎", "壮");
        DoubleLink doubleLink = new DoubleLink();

        /*1.添加*/
        doubleLink.addByOrder(heroNode1);
        doubleLink.addByOrder(heroNode2);
        doubleLink.addByOrder(heroNode5);
        doubleLink.addByOrder(heroNode3);
        /*2.显示*/
        doubleLink.list();

        /*    *//*3.修改*//*
        HeroNode2 heroNode5Update = new HeroNode2(5, "武二二二二郎", "壮");
        doubleLink.update(heroNode5Update);
        System.out.println("修改后的数据");
        doubleLink.list();

        *//*4.删除*//*
        doubleLink.delete(5);
        System.out.println("删除");
        doubleLink.list();*/

        /*  *//*5.插入数据*//*
        HeroNode2 heroNode4 = new HeroNode2(4, "张三", "法王");
        doubleLink.addByOrder(heroNode4);
        doubleLink.list();*/
    }
}

class DoubleLink {
    public static HeroNode2 head = new HeroNode2(1, "", "");

    /*1.显示链表里面的信息*/
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
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

    /*2.添加信息*/
    public void add(HeroNode2 heroNode) {
        /*01，在去创建一个变量，指向这个头节点
         *     然后去辅助遍历链表，从而可以更好的
         *    找到数据，下面的方式利用了多个变量指向
         *    同一个堆空间地址的方式，*/
        HeroNode2 temp = head;

        /*02.遍历整个链表，找到最后一个节点信息
         *    为null的*/
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.per = temp;
    }

    /*3.修改节点的信息*/
    public void update(HeroNode2 newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
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

    /*4.删除节点信息*/
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp.no == no) {
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
             *    就会被删除,在if里面的语句要是执行的话
             *   本来是最后一个了，null.per就是出现空指针异常*/
            temp.per.next = temp.next;
            if (temp.next != null) {
                temp.next.per = temp.per;
            }
        } else {
            System.out.println("链表到最后，没有要找到要删除的数据");
        }
    }

    /*5.按照顺序排序
     *   插入数据也可以*/
   /* public void addByOrder(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.no > heroNode.no) {
                break;
            }
            if (temp.no == heroNode.no) {
                flag = true;
                break;
            }
            *//*01.只要是不满足条件的，就往下面执行，把temp指向下一个节点对象*//*
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("准备插入的英雄编号%d已经存在，不能加入\n", heroNode.no);
        } else {
            heroNode.next=temp;
            heroNode.per=temp.per;
            temp.per.next=heroNode;
            temp.per=heroNode;
        }
    }*/


    public void addByOrder(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("该编号已存在! 无法添加");
        } else {
            if (temp.next == null) {
                // 添加到后面
                temp.next = heroNode;
                heroNode.per = temp;
            } else {
                heroNode.next = temp.next;
                temp.next.per = heroNode;
                temp.next = heroNode;
                heroNode.per = temp;
            }
        }
    }
}

class HeroNode2 {
    public int no;
    public String name;
    public String nickname;//昵称
    /*指向后面一个节点
     * 指向了之后，就可以获取这个节点里面的信息了*/
    public HeroNode2 next;
    /*指向前面一个节点*/
    public HeroNode2 per;

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

