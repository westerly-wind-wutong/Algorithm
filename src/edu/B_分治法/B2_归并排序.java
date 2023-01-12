package edu.B_分治法;

/**
 * @Author WesterlyWindWuTong
 * @Date 2023/1/12 23:18
 * @Version 1.0
 * @Description:
 */
public class B2_归并排序 {
    public static void main(String[] args) {
        int[] r = new int[]{8, 1, 9, 2, 6};
        MergeSort(r, 0, r.length - 1);
        for (int i = 0; i < r.length; i++) {
            System.out.print(r[i] + " ");
        }
    }

    public static void Merge(int[] r, int[] r1, int s, int m, int t)          //合并子序列
    {
        int i = s, j = m + 1, k = s;
        while (i <= m && j <= t) {
            if (r[i] <= r[j])                     //取r[i]和r[j]中较小者放入r1[k]
                r1[k++] = r[i++];
            else
                r1[k++] = r[j++];
        }
        while (i <= m) {                //若第一个子序列没处理完，则进行收尾处理
            r1[k++] = r[i++];
        }
        while (j <= t) {                 //若第二个子序列没处理完，则进行收尾处理
            r1[k++] = r[j++];
        }
    }

    public static void MergeSort(int[] r, int s, int t) {
        int m;
        int[] r1 = new int[1000];
        if (s == t) return;                 //递归的边界条件
        else {
            m = (s + t) / 2;                  //划分
            MergeSort(r, s, m);           //求解子问题1，归并排序前半个子序列
            MergeSort(r, m + 1, t);         //求解子问题2，归并排序后半个子序列
            Merge(r, r1, s, m, t);            //合并解，合并相邻有序子序列
            for (int i = s; i <= t; i++)
                r[i] = r1[i];
        }
    }
}
