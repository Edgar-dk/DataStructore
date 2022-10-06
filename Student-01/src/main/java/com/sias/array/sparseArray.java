package com.sias.array;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Edgar
 * @create 2022-10-06 19:18
 * @faction:
 */
public class sparseArray {
    public static void main(String[] args) throws IOException {
        int[][] ints = new int[11][11];
        ints[1][2] = 1;
        ints[2][3] = 2;
        ints[4][5] = 8;
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print("\t" + i);
            }
            System.out.println();
        }

        /*2.筛选二维数组中有几个非0的数*/
        int sum=0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (ints[i][j]!=0){
                    sum++;
                }
            }
        }
        /*3.创建稀疏数组
        *   所有的稀疏数组，列都是三个，行的话，多少个数，然后在+
        *   上一个1，这个1 是最上面的统计二维数组的位置数据*/
        int[][] sparseArray = new int[sum + 1][3];

        /*4.给稀疏数组赋值*/
        sparseArray[0][0] =11;
        sparseArray[0][1] =11;
        sparseArray[0][2] =sum;

        /*5.将二维数组里面的数据遍历到稀疏数组中
        *
        *   count正好是0，+1的话，正好从第2行开始，也把数据
        *   记录下了稀疏数组里面*/
        int count=0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (ints[i][j]!=0){
                    count++;
                    sparseArray[count][0]=i;
                    sparseArray[count][1]=j;
                    sparseArray[count][2]=ints[i][j];
                }
            }
        }
        /*6.打印稀疏数组*/
        for (int[] ints1 : sparseArray) {
            for (int i : ints1) {
                System.out.print("\t"+i);
            }
            System.out.println();
        }

        System.out.println("将稀疏数组转换成二维普通数组");

        /*7.转换的时候，需要把下标填写好，去获取稀疏数组里面的数据
        *   然后在放进新数组里面充当多少行和多少列*/
        int[][] chessArr2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i=1;i<sparseArray.length;i++){
            chessArr2[sparseArray[i][0]][sparseArray[i][1]]=sparseArray[i][2];
        }
        for (int[] ints1 : chessArr2) {
            for (int i : ints1) {
                System.out.print("\t"+i);
            }
            System.out.println();
        }
        String write="d:\\arr.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(write);

        for (int[] ints1 : chessArr2) {
            for (int i : ints1) {
                fileOutputStream.write(i);
            }
        }
        fileOutputStream.close();
    }
}
