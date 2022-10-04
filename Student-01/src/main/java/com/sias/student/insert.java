package com.sias.student;

import org.junit.Test;

import java.beans.beancontext.BeanContextServiceRevokedEvent;
import java.lang.reflect.Array;
import java.net.StandardSocketOptions;
import java.util.Arrays;

/**
 * @author Edgar
 * @create 2022-10-04 19:33
 * @faction:
 */
public class insert {
    public static void main(String[] args) {
        int arr []={1,3,6,2};
        insertSort(arr);
    }
    public static void insertSort(int arr[]) {
        if (arr == null && arr.length < 2) {
            return;
        }
        /*1.外边的for循环控制从哪一个开始
         *   里面的for循环控制每一步的进行
         *   最重要的一步就是，在里面的那个for循环
         *   先，判断一个数，然后在里面for中进行数据交换
         *   最重要的就是j=i-1既判断好了，数据的最后，也判断好了
         *   数据之前*/
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j+1]; j--) {
                exchange(arr, j, j + 1);
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void exchange(int arr[], int i, int j) {
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];
    }


}
