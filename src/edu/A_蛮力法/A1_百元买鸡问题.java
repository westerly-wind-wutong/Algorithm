package edu.A_蛮力法;

/**
 * @Author WesterlyWindWuTong
 * @Date 2023/1/10 01:09
 * @Version 1.0
 * @Description:
 */
public class A1_百元买鸡问题 {
    public static void main(String[] args) {
        Chicken();
    }

    private static void Chicken() {
        int x, y, z;                            //x、y和z分别表示公鸡、母鸡和小鸡的个数
        int count = 0;                          //解的个数初始化为0
        for (x = 0; x <= 20; x++) {             //公鸡个数x的范围是0到20
            for (y = 0; y <= 33; y++) {         //母鸡个数y的范围是0到33
                z = 100 - x - y;                //满足方程x + y + z = 100
                if ((z % 3 == 0) && (5 * x + 3 * y + z / 3 == 100)) {   //满足总价是100元
                    count++;                                            //解的个数加1
                    System.out.println("公鸡：" + x + "  母鸡：" + y + "  小鸡：" + z);
                }
            }
        }
        if (count == 0)
            System.out.println("问题无解");
    }
}
