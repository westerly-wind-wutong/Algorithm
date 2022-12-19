package BruteForceMethod;

public class SequentialSearch {          // 顺序查找
    public static void main(String[] args) {
        int[] r = {0, 1, 5, 3, 9, 4};
        int k1 = SeqSearch1(r, 3);
        int k2 = SeqSearch2(r, 3);
        System.out.println(k1+"  "+k2);
    }

    private static int SeqSearch1(int[] r, int k) {     //数组r[1] ~ r[n]存放查找集合
        int i = r.length - 1;
        while (i > 0 && r[i] != k) {          //检测比较位置是否越界
            i--;
        }
        return i;
    }
    private static int SeqSearch2(int[] r,int k) {      //数组r[1] ~ r[n]存放查找集合
        int i = r.length - 1;
        r[0] = k;                   //设置哨兵
        while (r[i] != k){          //不用检测比较位置是否越界
            i--;
        }
        return i;
    }
}
