package com.sias.linked;

/**
 * @author Edgar
 * @create 2022-10-12 9:58
 * @faction:
 */
public class SingleAnnularDemo {
    public static void main(String[] args) {
        SingleAnnular singleAnnular = new SingleAnnular();
        singleAnnular.addBody(125);
        singleAnnular.showBody();
        singleAnnular.countBody(10,20,125);
    }
}

class SingleAnnular {
    public Body first = null;

    /*1.创建小孩子*/
    public void addBody(int nums) {
        if (nums < 1) {
            System.out.println("添加的数量不能小于1");
            return;
        }
        /*00.辅助指针，去遍历元素*/
        Body curBody = null;
        for (int i = 1; i <= nums; i++) {
            /*01.根据编号去创建小孩子*/
            Body body = new Body(i);
            if (i==1){
                first=body;
                first.setNext(first);
                curBody=first;
            }else {
                curBody.setNext(body);
                body.setNext(first);
                curBody=body;
            }
        }
    }

    /*2.显示链表信息*/
    public void showBody(){
        if (first==null){
            System.out.println("链表没有数据");
            return;
        }
        Body curBody=first;
        while (true){
            System.out.printf("小孩的编号是%d\n",curBody.getNo());
            /*01.说明已经遍历到了最后*/
            if (curBody.getNext()==first){
                break;
            }
            curBody=curBody.getNext();
        }


    }

    /*3.记录小孩出圈的顺序*/
    public void countBody(int startNo,int countNum,int nums){
        /*01.第一个后面不可以为空，不可以从第0个开始
        *    以及不可以把开始的大于总数*/
        if (first==null||startNo<1||startNo>nums){
            System.out.println("你输入的参数有误");
            return;
        }
        Body herpes=first;
        /*02.指向最后一个节点位置*/
        while (true){
            if (herpes.getNext()==first){
                break;
            }
            herpes=herpes.getNext();
        }
        /*03.由于在第几个开始报数，是不知道的，所以需要把first移动到指定的位置*/
        for (int i=0;i<startNo-1;i++){
            first=first.getNext();
            herpes=herpes.getNext();
        }
        /*04.小孩出圈*/
        while (true){
            if(herpes==first){
                break;
            }
            /*05.把first和help移动到指定的位置，
            *    可以从第几个节点开始出圈*/
            for (int j = 0; j < countNum-1; j++) {
                first=first.getNext();
                herpes=herpes.getNext();
            }
            System.out.printf("小孩%d出圈\n",first.getNo());
            /*06.改变节点只想，堆里面没有指向的会被销毁*/
            first=first.getNext();
            herpes.setNext(first);
        }
        System.out.printf("最后一个小孩的节点%d\n",first.getNo());
    }
}


class Body {
    public int no;
    public Body next;

    public Body(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Body getNext() {
        return next;
    }

    public void setNext(Body next) {
        this.next = next;
    }
}
