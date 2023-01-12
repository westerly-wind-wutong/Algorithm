package edu.B_分治法;

/**
 * @Author WesterlyWindWuTong
 * @Date 2023/1/13 00:14
 * @Version 1.0
 * @Description:
 */
public class B3_快速排序 {
    public static void main(String[] args) {
        int[] r ={23,13,35,6,19,50,28};
        QuickSort(r,0,6);
        for(int i=0;i<7;i++)
            System.out.println(r[i]+" ");
    }
    private static int Partition(int[] r, int first, int end)          //划分
    {
        int i = first, j=end;                       //初始化待划分区间
        while (i < j)
        {
            while (i < j && r[i] <= r[j]) j--;          //右侧扫描
            if (i < j) {
                int temp = r[i]; r[i] = r[j]; r[j] = temp;     //将较小记录交换到前面
                i++;
            }
            while (i < j && r[i] <= r[j]) i++;         //左侧扫描
            if (i < j) {
                int temp = r[i]; r[i] = r[j]; r[j] = temp;     //将较大记录交换到后面
                j--;
            }
        }
        return i;                                // 返回轴值记录的位置
    }
    private static void QuickSort(int[] r, int first, int end)        //快速排序
    {
        int pivot;
        if (first < end) {
            pivot = Partition(r, first, end);    //划分，pivot是轴值在序列中的位置
            QuickSort(r, first, pivot-1);      //求解子问题1，对左侧子序列进行快速排序
            QuickSort(r, pivot+1, end);      //求解子问题2，对右侧子序列进行快速排序
        }
    }
}
