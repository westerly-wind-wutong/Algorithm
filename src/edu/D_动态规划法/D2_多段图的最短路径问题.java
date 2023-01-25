package edu.D_动态规划法;

import java.util.Scanner;

/**
 * @Author WesterlyWindWuTong
 * @Date 2023/1/21 20:44
 * @Version 1.0
 * @Description: 问题：设图 G =（V,E）是一个带权有向图，如果把顶点集合 V 划分成 k 个互不相交的子集 Vi（2<=k<=n,1<=i<=k），
 * 使得 E 中的任何一条边 <u,v>，必有 u∈Vi, v∈Vi + m(1<=i<k, 1<i+m<=k),则称图 G 为多段图，称 s∈V1 为源点，t∈Vk 为终点。
 * 多段图的最短路径问题为从源点到终点的最小代价路径。
 */
public class D2_多段图的最短路径问题 {
    private static int N = 20;
    private static int MAX = 1000;
    private static int[][] arc = new int[N][N];               //存储弧上的权值

    public static void main(String[] args) {
        int n = creatGraph();
        int pathLen = Backpath(n);
        System.out.println("最短路径的长度为：" + pathLen);
    }

    private static int creatGraph() {
        int i, j, k;
        int weight;
        int vnum, arcnum;
        System.out.println("请输入顶点的个数和边的个数：");
        Scanner scanner1 = new Scanner(System.in);
        vnum = scanner1.nextInt();
        Scanner scanner2 = new Scanner(System.in);
        arcnum = scanner2.nextInt();
        for (i = 0; i < vnum; i++)
            for (j = 0; j < vnum; j++)
                arc[i][j] = MAX;
        for (k = 0; k < arcnum; k++) {
            System.out.println("请输入边的两个顶点和权值：");
            Scanner scanner3 = new Scanner(System.in);
            i = scanner3.nextInt();
            Scanner scanner4 = new Scanner(System.in);
            j = scanner4.nextInt();
            Scanner scanner5 = new Scanner(System.in);
            weight = scanner5.nextInt();
            arc[i][j] = weight;
        }
        return vnum;
    }

    private static int Backpath(int n) {
        int i, j, temp;
        int[] cost = new int[N];
        int[] path = new int[N];
        for (i = 0; i < n; i++) {
            cost[i] = MAX;
            path[i] = -1;
        }
        cost[0] = 0;
        for (j = 1; j < n; j++) {
            for (i = j - 1; i >= 0; i--) {
                if (arc[i][j] + cost[i] < cost[j]) {
                    cost[j] = arc[i][j] + cost[i];
                    path[j] = i;
                }
            }
        }
        System.out.print("最短路径为：");
        System.out.print(n - 1);
        i = n - 1;
        while (path[i] >= 0) {
            System.out.print("<-" + path[i]);
            i = path[i];
        }
        System.out.println();
        return cost[n - 1];
    }
}
