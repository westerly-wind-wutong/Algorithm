package edu.E_贪心法;

/**
 * @Author WesterlyWindWuTong
 * @Date 2023/1/30 00:11
 * @Version 1.0
 * @Description:
 */
public class E4_背包问题 {
    private static final int n = 3;

    public static void main(String[] args) {
        int[] w = {10, 30, 20};
        int[] v = {50, 120, 60};
        int C = 50;
        int value = KnapSack(w, v, 3, C);
        System.out.println("背包获得的最大价值是：" + value);
    }

    private static int KnapSack(int[] w, int[] v, int n, int C) {
        double[] x = new double[10];           //物品可部分装入
        int maxValue = 0;
        int i;
        for (i = 0; w[i] < C; i++) {
            x[i] = 1;                 //将物品i装入背包
            maxValue += v[i];
            C = C - w[i];             //背包剩余容量
        }
        x[i] = (double) C / w[i];        //物品i装入一部分
        maxValue += x[i] * v[i];
        return maxValue;              //返回背包获得的价值
    }
}
