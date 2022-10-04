package com.sias.student;

import org.junit.Test;
import sun.java2d.windows.GDIBlitLoops;

/**
 * @author Edgar
 * @create 2022-10-04 18:11
 * @faction:
 */
public class operation {
    public static void main(String[] args) {
        int add[] = {1, 1, 1, 4, 4, 5, 5, 9,8,8};
        AandB(add);
    }

    public static void AandB(int arr[]) {
        int eor = 0;
        for (int i : arr) {
            eor ^= i;
        }
        /*1.按照位取反，暂时没有理解什么含义，
        *   */
        int rightOne = eor & (~eor + 1);
        int onlyOne = 0;

        for (int cur : arr) {
            if ((cur & rightOne) == 0) {
                onlyOne ^= cur;
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }

    @Test
    public void fa(){
        String name="甲";
        String name1="乙";
        int ad=1;
        int gf=1;
        int fd=0;
        int gsd=4;
        int gb=5;
        System.out.println(gsd&gb&ad);
        System.out.println(ad&gf&gsd&fd);
        System.out.println(ad&fd);
        System.out.println(ad^fd^gsd);
    }
}
