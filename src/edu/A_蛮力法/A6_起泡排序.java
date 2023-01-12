package edu.A_蛮力法;

/**
 * @Author WesterlyWindWuTong
 * @Date 2023/1/10 01:40
 * @Version 1.0
 * @Description:
 */
public class A6_起泡排序 {
    public static void main(String[] args) {
        int[] r ={1,6,7,5,3,8,9,2};
        BubbleSot(r,8);
        for(int i=0;i<8;i++)
            System.out.print(r[i]+"  ");
        System.out.println();
    }
    private static void BubbleSot(int[] r, int n){
        int bound, exchange = n-1;
        while (exchange != 0){
            bound=exchange;
            exchange=0;
            for (int j = 0; j<bound;j++){
                if(r[j]>r[j+1]){
                    int temp = r[j];
                    r[j]=r[j+1];
                    r[j+1]=temp;
                    exchange = j;
                }
            }
        }
    }
}
