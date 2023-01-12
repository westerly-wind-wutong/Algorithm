package edu.A_蛮力法;

/**
 * @Author WesterlyWindWuTong
 * @Date 2023/1/10 01:18
 * @Version 1.0
 * @Description:
 */
public class A3_串匹配BF算法 {
    public static void main(String[] args) {
        String str = "abcabcabcaccb";
        String sub = "abcacc";
        char[] S = str.toCharArray();
        char[] T = sub.toCharArray();
        int index = BF(S, T);
        for (int i = 1; i < index; i++)
            System.out.print(" ");
        System.out.println(sub + "在");
        System.out.println(str + "中的位置是：" + index);
    }

    private static int BF(char[] S, char[] T) {
        int index = 0;                              //主串从下标0开始第一趟匹配
        int i = 0, j = 0;                           //设置比较的起始下标
        while (i < S.length && j < T.length) {
            if (S[i] == T[j]) {
                i++;
                j++;
            } else {                //i和j分别回溯
                index++;
                i = index;
                j = 0;
            }
        }
        if (j == T.length) {
            return index + 1;       //返回本趟匹配开始的位置（不是下标）
        } else {
            return -1;
        }
    }
}
