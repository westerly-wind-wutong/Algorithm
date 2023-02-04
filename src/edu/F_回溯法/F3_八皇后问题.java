package edu.F_回溯法;

import java.util.Scanner;

/**
 * @Author WesterlyWindWuTong
 * @Date 2023/2/4 20:54
 * @Version 1.0
 * @Description:
 */
public class F3_八皇后问题 {


    public static int N = 100;
    public static int[] x = new int[N];

    public static void main(String[] args) {
        x[0] = -1;
        int n;
        System.out.print("请输入皇后的个数:");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        scanner.close();
        Queue(n);
    }

    //空行，以下是其他函数定义
    private static void Queue(int n)                              //函数定义，求解n皇后问题
    {
        int k = 0;                                   //num存储解的个数
        while (k >= 0)                               //摆放皇后k，注意0≤k＜n
        {
            x[k]++;                                       //在下一列摆放皇后k
            while (x[k] < n && Place(k) == 1)                           //发生冲突
                x[k]++;                                       //皇后k试探下一列
            if (x[k] < n && k == n - 1)                         //得到一个解，输出
            {
                for (int i = 0; i < n; i++)
                    System.out.print(x[i] + 1 + "  ");      //数组下标从0开始，打印的列号从1开始
                System.out.println();
                return;                         //只求出一个解即可
            } else if (x[k] < n && k < n - 1)                         //尚有皇后未摆放
                k = k + 1;                               //准备摆放下一个皇后
            else
                x[k--] = -1;                  //重置x[k]，回溯，重新摆放皇后k
        }
        System.out.println("无解");
    }

    private static int Place(int k)                    //考察皇后k放置在x[k]列是否发生冲突
    {
        for (int i = 0; i < k; i++)
            if (x[i] == x[k] || Math.abs(i - k) == Math.abs(x[i] - x[k]))             //违反约束条件
                return 1;                                          //冲突，返回1
        return 0;                                            //不冲突，返回0
    }
}
