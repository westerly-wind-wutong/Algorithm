package edu.F_回溯法;

/**
 * @Author WesterlyWindWuTong
 * @Date 2023/2/2 20:13
 * @Version 1.0
 * @Description:
 */
public class F2_哈密顿回路问题 {
    private static final int n = 5;
    private static final int[][] arc = {{0,1,1,0,0},{1,0,1,1,1},{1,1,0,0,1},{0,1,0,0,1},{0,1,1,1,0}};

    public static void main(String[] args) {
        int[] x = new int[n];
        Hamiton(x, n) ;
    }
    private static void Hamiton(int[] x, int n)
    {
        int i, k;
        int[] visited = new int[10];//假设图最多有10个顶点
        for (i = 0; i < n; i++)                     //初始化顶点数组和标志数组
        {
            x[i] = 0;
            visited[i] = 0;
        }
        x[0] = 0; visited[0] = 1;              //从顶点0出发
        k = 1;
        while (k >= 1)
        {
            x[k] = x[k] + 1;                       //搜索下一顶点
            while (x[k] < n)
                if (visited[x[k]] == 0 && arc[x[k-1]][x[k]] == 1) break;
                else x[k] = x[k] + 1;
            if (x[k] < n && k == n - 1 && arc[x[k]][1] == 1) {
                for (k = 0; k < n; k++ )
                    System.out.print(x[k]+1+"  ");           //输出顶点的编号，编号从1开始
                return;
            }
            else if (x[k] < n && k < n - 1 ) {
                visited[x[k]] = 1;
                k = k + 1;
            }
            else {                          //回溯
                visited[x[k]] = 0;
                x[k] = 0;  k = k - 1;
            }
        }
}
}
