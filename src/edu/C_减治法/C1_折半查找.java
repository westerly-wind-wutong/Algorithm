package edu.C_减治法;

/**
 * @Author WesterlyWindWuTong
 * @Date 2023/1/16 18:33
 * @Version 1.0
 * @Description: 折半查找(二分查找)
 */
public class C1_折半查找 {
    public static void main(String[] args) {
        int[] r = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("该元素的下标为：" + BinSearch(r, 7));
    }

    public static int BinSearch(int[] r, int k) {    //迭代查找，参数：数组，数组长度，查找值
        int low = 0, high = r.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (k < r[mid]) {
                high = mid - 1;
            } else if (k > r[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
