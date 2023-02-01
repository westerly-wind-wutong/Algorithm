package edu.E_贪心法;

/**
 * @Author WesterlyWindWuTong
 * @Date 2023/2/1 21:49
 * @Version 1.0
 * @Description:
 */
public class E6_多机调度问题 {
    public static final int n = 7;
    public static final int m = 3;

    public static void main(String[] args) {
        int[] t = {16, 14, 6, 5, 4, 3, 2};
        int[] d = new int[m];
        MultiMachine(t, n, d, m);
    }

    private static void MultiMachine(int[] t, int n, int[] d, int m) {
        int[][] S = new int[3][7];      //S[i]为存储机器i处理作业的队列，rear[i]为队尾下标
        int[] rear = new int[3];
        int i, j, k;
        for (i = 0; i < m; i++)          //安排前m个作业
        {
            S[i][0] = i+1;
            rear[i] = 0;     //每个作业队列均只有一个作业
            d[i] = t[i];
        }
        for (i = m; i < n; i++)             //依次安排余下的每一个作业
        {
            for (j = 0, k = 1; k < m; k++)   //查找最先空闲的机器
                if (d[k] < d[j]) j = k;
            rear[j]++;
            S[j][rear[j]] = i+1;     //将作业i插入队列S[j]
            d[j] = d[j] + t[i];
        }
        for (i = 0; i < m; i++)               //输出每个机器处理的作业
        {
            System.out.print( "机器" + i + "：");
            for (j = 0; S[i][j] > 0; j++)
                System.out.print("作业" + S[i][j] + "  ");
            System.out.println();
        }
    }
}
