package edu.C_减治法;

/**
 * @Author WesterlyWindWuTong
 * @Date 2023/1/17 19:36
 * @Version 1.0
 * @Description:
 */
public class C3_选择问题 {
    public static void main(String[] args) {
        int[] r ={5,3,8,1,10,6,9,12,17};
        int k = 3;
        int x = MinK(r,0,8,k-1);
        System.out.println("第"+k+"小的元素是"+x);
    }
    private static int Partition(int[] r, int low, int high)          //划分
    {
        int i = low, j=high;                       //初始化待划分区间
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

    private static int MinK(int[] r, int low, int high, int k)  //k为第k小元素
    {
        int s;              //s为轴值位置
        s = Partition(r, low, high);
        if (s == k)
            return r[s];
        if(s > k)
            return MinK(r, low, s-1, k);
        else
            return MinK(r, s+1, high, k);
    }
}
