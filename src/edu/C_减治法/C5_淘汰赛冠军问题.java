package edu.C_减治法;

/**
 * @Author WesterlyWindWuTong
 * @Date 2023/1/19 21:16
 * @Version 1.0
 * @Description:
 */
public class C5_淘汰赛冠军问题 {
    public static void main(String[] args) {
        char[] r = {'A', 'F', 'G', 'B', 'E', 'H', 'C', 'D'};
        char c = Game(r);
        System.out.print("最后的冠军是：" + c);
    }

    private static boolean Comp(char a, char b) {
        return a > b;
    }
    private static char Game(char[] r)
    {
        int i = r.length;
        while (i > 1)                        //比赛直到剩余1人即为冠军
        {
            i = i/2;
            for (int j = 0; j < i; j++)
                if (Comp(r[j+i], r[j]))            //胜者存入r[j]中
                    r[j] = r[j+i];
        }
        return r[0];
    }
}
