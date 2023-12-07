package leetcode;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<String> s = new ArrayList<>();
        s.add("1,2,3,\"4,5,6\",7,\"811,11");
        s.add("11,1\",9,10,\"11,12,13\",14,\"");
        s.add("1,15\",\"12,12,12");
        s.add("\"");
        List<String> resList = new ArrayList<>();
        StringBuilder oneDataString = new StringBuilder();
        boolean flag = false;
        int i = 0;
        while (resList.size() != 12) {
            String temps = s.get(i);
            String[] tempsList = temps.split(",");
            for (int j = 0; j < tempsList.length; j++) {
                if ("\"".equals(tempsList[j])) {
                    flag = !flag;
                    oneDataString.append(tempsList[j]);
                    if (!flag) {
                        resList.add(oneDataString.toString());
                        oneDataString.delete(0, oneDataString.length());
                    }
                } else if (!tempsList[j].startsWith("\"") && tempsList[j].endsWith("\"") && flag) {
                    flag = false;
                    oneDataString.append(tempsList[j]);
                    resList.add(oneDataString.toString());
                    oneDataString.delete(0, oneDataString.length());
                } else if (tempsList[j].startsWith("\"") && !tempsList[j].endsWith("\"") || flag) {
                    flag = true;
                    oneDataString.append(tempsList[j]);
                    if (j != tempsList.length - 1) {
                        oneDataString.append(",");
                    }
                } else {
                    resList.add(tempsList[j]);
                }
            }
            i++;
        }
        System.out.println(resList);
    }
}
