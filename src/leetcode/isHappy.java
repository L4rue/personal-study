package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class isHappy {
    public static void main(String[] args) {
        boolean flag = isHappy(23);
        System.out.println(flag);
    }
    public  static Set<Integer> nums = new HashSet<>();
    public static  boolean isHappy(int n) {
        nums.add(n);
        int num = 0;
        while (n!=0) {
            int s = n % 10;
            num = num + s * s;
            n = n / 10;
        }
        if(num == 1 || num == 10) {
            return true;
        } else if (nums.contains(num)) {
            return  false;
        } else {
            return isHappy(num);
        }


    };


}
