package edu.A_蛮力法;

/**
 * @Author WesterlyWindWuTong
 * @Date 2023/1/10 01:35
 * @Version 1.0
 * @Description:
 */
public class A5_选择排序 {
    public static void main(String[] args) {
        int[] r ={1,6,7,5,3,8,9,2};
        SelectSort(r,8);
        for(int i=0;i<8;i++)
            System.out.print(r[i]+"  ");
        System.out.println();
    }
    private static void SelectSort(int r[ ], int n)
    {
        int i, j, index, temp;
        for (i = 0; i < n - 1; i++)  	            //对n个记录进行n-1趟选择排序
        {
            index = i;
            for (j = i + 1; j < n; j++)           //在无序区中查找最小记录
                if (r[j] < r[index]) index = j;
            if (index != i) {
                temp = r[i]; r[i] = r[index]; r[index] = temp;
            }//交换记录
        }
    }
}
