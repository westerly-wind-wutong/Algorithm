package edu.E_贪心法;

/**
 * @Author WesterlyWindWuTong
 * @Date 2023/1/28 20:40
 * @Version 1.0
 * @Description: 问题: TSP问题是指旅行家要旅行n个城市,要求各个城市经历且仅经历一次然后回到出发城市,并要求所走的路程最短。
 */
public class E2_TSP问题 {
    private static final int n = 5;
    private static final int max = 100;

    public static void main(String[] args) {
        int[][] arc = {{max, 3, 3, 2, 6}, {3, max, 7, 3, 2}, {3, 7, max, 2, 5}, {2, 3, 2, max, 3}, {6, 2, 5, 3, max}};
        int minDist = TSP1(arc, 0);
        System.out.println("最短哈密顿回路的长度是：" + minDist);
    }

    private static int TSP1(int[][] arc, int w) {
        int edgeCount = 0, TSPLength = 0;
        int min, u, v = 0;
        int[] flag = new int[n];                    //顶点均未加入哈密顿回路
        u = w;
        flag[w] = 1;
        while (edgeCount < n - 1)               //循环直到边数等于n-1
        {
            min = 100;
            for (int j = 0; j < n; j++)       //求arc[u]中的最小值
                if ((flag[j] == 0) && (arc[u][j] != 0) && (arc[u][j] < min)) {
                    v = j;
                    min = arc[u][j];
                }
            TSPLength += arc[u][v];
            flag[v] = 1;
            edgeCount++;           //将顶点加入哈密顿回路
            System.out.println(u + "-->" + v);          //输出经过的路径
            u = v;
        }
        System.out.println(v + "-->0");               //输出最后的回边
        return (TSPLength + arc[v][0]);
    }
}
