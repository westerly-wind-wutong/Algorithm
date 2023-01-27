package edu.E_贪心法;

import java.util.Scanner;

/**
 * @Author WesterlyWindWuTong
 * @Date 2023/1/27 21:54
 * @Version 1.0
 * @Description:
 */
public class E1_埃及分数 {
    public static void main(String[] args) {
        int A, B;
        System.out.println("请输入真分数的分子：");
        Scanner scannerA = new Scanner(System.in);
        A = scannerA.nextInt();
        System.out.println("请输入真分数的分母：");
        Scanner scannerB = new Scanner(System.in);
        B = scannerB.nextInt();
        EgyptFraction(A, B);
    }

    private static void EgyptFraction(int A, int B) {
        int E, R;
        System.out.print(A + "/" + B + " = ");      //输出真分数A/B
        do {
            E = B / A + 1;                    //求真分数A/B包含的最大埃及分数
            System.out.print("1/" + E + " + ");       //输出1/E
            A = A * E - B;                   //以下两条语句计算A/B - 1/E
            B = B * E;
            R = CommFactor(B, A);        //函数调用，求A和B的最大公约数
            if (R > 1)                      //最大公约数大于1，即A/B可以化简
            {
                A = A / R;
                B = B / R;             //将A/B化简
            }
        } while (A > 1);                   //当A/B不是埃及分数时执行循环
        System.out.println("1/" + B);         //输出最后一个埃及分数1/B
    }

    private static int CommFactor(int m, int n) {
        int r = m % n;
        while (r != 0) {
            m = n;
            n = r;
            r = m % n;
        }
        return n;
    }
}