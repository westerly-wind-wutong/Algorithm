package edu.A_蛮力法;

/**
 * @Author WesterlyWindWuTong
 * @Date 2023/1/11 00:35
 * @Version 1.0
 * @Description:
 */
public class A8_凸包问题 {
    public static void main(String[] args) {
        int[] x ={1,3,5,1,2, 2,2};
        int[] y ={1,1,4,3,2,3,6};
        BulgePack(x,y,7);
    }
    private static void BulgePack(int[] x, int[] y, int n)
    {
        int i, j, k, sign1, sign2;
        int a, b, c;
        for (i = 0; i < n - 1; i++)
            for (j = i + 1; j < n; j++)
            {
                sign1 = 0; sign2 = 0;
                a = y[i] - y[j]; b = x[j] - x[i]; c = x[i] * y[j] - y[i] * x[j];
                for (k = 0; k < n; k++)
                {
                    if (k != i && k != j) {
                        if (a * x[k] + b * y[k] + c > 0) sign1 = 1;
                        else sign2 = 1;
                        if (sign1 == sign2) break;            //两个半平面均有点
                    }
                }
                if (k == n)                            //点i和j是极点
                    System.out.println("("+i+","+j+")");
            }
    }
}
