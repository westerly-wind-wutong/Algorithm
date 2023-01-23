package edu.D_动态规划法;

/**
 * @Author WesterlyWindWuTong
 * @Date 2023/1/23 22:10
 * @Version 1.0
 * @Description: 最长公共子序列问题
 */
public class D4_最长公共子序列问题 {
    private static int[][] L = new int[10][10];
    private static int[][] S = new int[10][10];
    public static void main(String[] args) {
        char[] x ={'a', 'b', 'c', 'b', 'd', 'b'};
        char[] y ={'a','c', 'b', 'b', 'a', 'b', 'd', 'b', 'b'};
        char[] z = new char[10];
        System.out.println("长度为："+CommonOrder(x,y,z));
    }

    private static int CommonOrder(char[] x, char[] y, char[] z)
    {
        int i, j, k;
        for (j = 0; j <= y.length; j++)                       //初始化第0行
            L[0][j] = 0;
        for (i = 0; i <= x.length; i++)                      //初始化第0列
            L[i][0]=0;
        for (i = 1; i <= x.length; i++)
        {
            for (j = 1; j <= y.length; j++)
            {
                if (x[i-1] == y[j-1])
                { L[i][j] = L[i-1][j-1] + 1;
                    S[i][j] = 1;
                }
                else if (L[i][j-1] >= L[i-1][j])
                {
                    L[i][j] = L[i][j-1];
                    S[i][j] = 2;
                }
                else
                {
                    L[i][j] = L[i-1][j];
                    S[i][j] = 3;
                }
            }
        }
        i = x.length; j = y.length; k = L[x.length][y.length];               //将公共子序列存储到数组z[k]中
        while (i >0 && j >0)
        {
            if (S[i][j] == 1) { z[k] = x[i-1]; k--; i--; j--; }
            else if (S[i][j] == 2) j--;
            else i--;
        }
        for (k =1; k <=L[x.length][y.length]; k++)          //输出最长公共子序列
            System.out.print(z[k]+" ");
        System.out.println();
        return L[x.length][y.length];                     //返回公共子序列长度
    }
}
