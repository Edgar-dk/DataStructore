package com.sias.student;

import org.junit.Test;

/**
 * @author Edgar
 * @create 2022-09-21 17:29
 * @faction:
 */
public class Xor {

    /*1.找出来偶数个的数字*/
    public static void XorTest(int arr []){
        /*01.这个error只是一个载体，用这个数去承接
        *    着数据的运算*/
        int error =0;
        for (int i : arr) {
            error^=i;
        }
        System.out.println(error);
    }

    @Test
    public void Test1(){
        int [] a ={1,1,3,3,3,4,4,};
        Xor.XorTest(a);
    }
}
