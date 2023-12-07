package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Zproblem {
    public static void main(String[] args) {
        String res = convert("0123456789", 5);
        System.out.println(res);
    }

    static public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> resList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            resList.add(new StringBuilder());
        }
        int round = 0;
        int flag = -1;
        for (int i = 0; i < s.length(); i++) {
            resList.get(round).append(s.charAt(i));
            if (round == numRows - 1 || round == 0) {
                flag = -flag;
            }
            round += flag;
        }
        StringBuilder res = new StringBuilder();
        resList.forEach(res::append);
        return res.toString();
    }
}
