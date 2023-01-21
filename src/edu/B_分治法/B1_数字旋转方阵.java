package edu.B_分治法;

import java.util.Scanner;

/**
 * @Author WesterlyWindWuTong
 * @Date 2023/1/12 23:18
 * @Version 1.0
 * @Description:
 */
public class B1_数字旋转方阵 {
    public static void main(String[] args) {
        int[][] data = new int[100][100];
        System.out.print("输入方阵的大小：");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.close();
        Full(1, 0, size, data);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                System.out.print(data[i][j] + "\t");
            System.out.println();
        }
        System.out.println();
    }

    static void Full(int number, int begin, int size, int[][] data) {             //从number 开始填写size 阶方阵，左上角的下标为(begin, begin)
        int i, j, k;
        if (size == 0)             //递归的边界条件，如果size等于0，则无须填写
            return;
        if (size == 1)                         //递归的边界条件，如果size等于1
        {
            data[begin][begin] = number;         //则只须填写number
            return;
        }
        i = begin;
        j = begin;                   //初始化左上角下标
        for (k = 0; k < size - 1; k++)            //填写区域A，共填写size - 1个数
        {
            data[i][j] = number;                 //在当前位置填写number
            number++;
            i++;                    //行下标加1
        }
        for (k = 0; k < size - 1; k++)            //填写区域B，共填写size - 1个数
        {
            data[i][j] = number;                 //在当前位置填写number
            number++;
            j++;                    //列下标加1
        }
        for (k = 0; k < size - 1; k++)            //填写区域C，共填写size - 1个数
        {
            data[i][j] = number;                //在当前位置填写number
            number++;
            i--;                    //行下标减1
        }
        for (k = 0; k < size - 1; k++)            //填写区域D，共填写size - 1个数
        {
            data[i][j] = number;                //在当前位置填写number
            number++;
            j--;                    //列下标减1
        }
        Full(number, begin + 1, size - 2, data);       //递归求解，左上角下标为begin + 1
    }
}
