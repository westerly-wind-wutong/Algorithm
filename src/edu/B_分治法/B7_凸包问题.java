package edu.B_分治法;

/**
 * @Author WesterlyWindWuTong
 * @Date 2023/1/16 18:28
 * @Version 1.0
 * @Description:
 */
public class B7_凸包问题 {
    public static void main(String[] args) {
        int[] x = {1, 3, 5, 1, 2, 2, 2};
        int[] y = {1, 1, 4, 3, 2, 3, 6};
        BulgePack(x, y);
    }

    private static void BulgePack(int[] x, int[] y) {
        int i, j, k, sign1, sign2;
        int a, b, c;
        for (i = 0; i < x.length - 1; i++)
            for (j = i + 1; j < x.length; j++) {
                sign1 = 0;
                sign2 = 0;
                a = y[i] - y[j];
                b = x[j] - x[i];
                c = x[i] * y[j] - y[i] * x[j];
                for (k = 0; k < x.length; k++) {
                    if (k != i && k != j) {
                        if (a * x[k] + b * y[k] + c > 0) sign1 = 1;
                        else sign2 = 1;
                        if (sign1 == sign2) break;            //两个半平面均有点
                    }
                }
                if (k == x.length)                              //点i和j是极点
                    System.out.println("(" + i + "," + j + ")");
            }
    }
}
