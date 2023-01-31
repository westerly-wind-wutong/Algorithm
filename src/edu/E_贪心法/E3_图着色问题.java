package edu.E_贪心法;

/**
 * @Author WesterlyWindWuTong
 * @Date 2023/1/29 22:52
 * @Version 1.0
 * @Description:
 */
public class E3_图着色问题 {
    private static final int N = 5;
    private static final int[][] arc = {{0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 0, 1}, {0, 1, 0, 0, 1}, {0, 0, 1, 1, 0}};
    private static final int[] color = new int[N];

    public static void main(String[] args) {
        ColorGraph();
        for (int i = 0; i < N; i++)
            System.out.println(color[i] + " ");
    }

    private static void ColorGraph() {
        int k = 0;
        int flag = 1;
        while (flag == 1) {
            k++;
            flag = 0;
            for (int i = 0; i < N; i++) {
                if (color[i] == 0) {
                    color[i] = k;
                    if (!Ok(i)) {
                        color[i] = 0;
                        flag = 1;
                    }
                }
            }
        }
    }

    private static Boolean Ok(int i)                        //判断顶点i的着色是否发生冲突
    {
        for (int j = 0; j < N; j++)
            if (arc[i][j] == 1 && color[i] == color[j]) return false;
        return true;
    }
}
