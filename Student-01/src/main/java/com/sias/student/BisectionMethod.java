package com.sias.student;

/**
 * @author Edgar
 * @create 2022-10-05 10:37
 * @faction:
 */
public class BisectionMethod {
    public static void main(String[] args) {
        String arr []={"gfd","2","3"};
        for (String s : arr) {
            boolean contains = s.contains("3");
            if (contains){
                System.out.println("里面含有这个值");
            }else {
                System.out.println("没有这个数据");
            }
        }
    }
}
