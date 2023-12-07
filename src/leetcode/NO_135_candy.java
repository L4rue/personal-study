package leetcode;

import java.util.Arrays;

public class NO_135_candy {
    public static void main(String[] args) {
        int num = candy(new int[]{1, 3, 4, 5,2});
        System.out.println(num);
    }      

    public static int candy(int[] ratings) {
        int[] resNums = new int[ratings.length];
        Arrays.fill(resNums,1);
        // 从左到右遍历一边数组，为分数递增的人分苹果
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                resNums[i] = resNums[i - 1] + 1;
            }
        }
        // 从右到左遍历一边数组，为分数递减的人分苹果
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i] && resNums[i - 1] <= resNums[i]) {
                resNums[i - 1] = resNums[i] + 1;
            }
        }
        int num = 0;
        for (int resNum : resNums) {
            num += resNum;
        }
        return num;
    }
}
