package edu.A_蛮力法;

/**
 * @Author WesterlyWindWuTong
 * @Date 2023/1/10 01:20
 * @Version 1.0
 * @Description:
 */
public class A4_串匹配KMP算法 {
    public static void main(String[] args) {
        String str = "ababcabcacbab";
        String sub = "abcac";
        char[] S = str.toCharArray();
        char[] T = sub.toCharArray();
        int index = KMP(S, T);
        for (int i = 1; i < index; i++)
            System.out.print(" ");
        System.out.println(sub + "在");
        System.out.println(str + "中的位置是：" + index);
    }

    public static int[] getNext(char[] t) {
        int[] next = new int[t.length];
        int i = 0;
        int j = -1;
        next[0] = -1;
        while (i < t.length - 1) {
            if (j == -1 || t[i] == t[j]) {
                i++;
                j++;
                if (t[i] != t[j]) {
                    next[i] = j;
                } else {
                    next[i] = next[j];
                }
            } else {
                j = next[j];
            }
        }
        return next;
    }

    private static int KMP(char[] s, char[] t) {
        int i = -1;
        int j = -1;
        int[] next = getNext(t);
        while (i < s.length && j < t.length) {
            if (j == -1 || s[i] == t[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == t.length) {
            return i - t.length;
        } else {
            return -1;
        }
    }
}
