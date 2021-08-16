package com;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String id = scanner.next();
        Solution(id);
    }

    public static int Solution(String id) {
        int[] q = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        String lastNum = "10X98765432";
        int sum = 0;
        int res;
        int count = 0;
        HashMap map = new HashMap();
        for (int i = 0; i < 11; i++) {
            map.put(lastNum.charAt(i), i);
        }
        for (int i = 0; i < 14; i++) {
            sum += (Integer.parseInt(String.valueOf(id.charAt(i))) * q[i]);
        }
        for (int i = 14; i < 17; i++) {
            if (String.valueOf(id.charAt(i)).equals("*")) {
                count++;
                if (count == 1) {
                    System.out.println(1);
                    return 0;
                }
            }
        }
        return 0;
    }
}
