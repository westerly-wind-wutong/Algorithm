package edu.E_贪心法;

/**
 * @Author WesterlyWindWuTong
 * @Date 2023/1/31 00:42
 * @Version 1.0
 * @Description:
 */
public class E5_活动安排问题 {
    private static final int n = 11;

    public static void main(String[] args) {
        int[] s = new int[]{1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12};
        int[] f = new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        int[] B = new int[n];
        int k = ActiveManage(s, f, B, n);
        System.out.println("最多可安排的活动个数是：" + k);
        System.out.print("具体的活动是：");
        for (int i = 0; i < n; i++)
            if (B[i] == 1)
                System.out.print("活动" + i + "  ");
        System.out.println();

    }

    private static int ActiveManage(int[] s, int[] f, int[] B, int n) {
        int i, j, count;
        B[0] = 1;
        j = 1;
        count = 1;
        for (i = 1; i < n; i++)                    //依次考察每一个活动
        {
            if (s[i] >= f[j]) {             //活动i与集合B中最后结束的活动j相容
                B[i] = 1;
                j = i;
                count++;
            } else B[i] = 0;
        }
        return count;                          //返回已安排的活动个数
    }
}
