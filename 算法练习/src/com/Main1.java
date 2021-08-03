package com;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main1 {
    public static void main(String[] args) {
        System.out.println(Solution());
    }

    public static int Solution() {
        Scanner scanner = new Scanner(System.in);
        String num[] = scanner.next().split(" ");
        int n = Integer.parseInt(num[0]);
        int m = Integer.parseInt(num[1]);
        int k = Integer.parseInt(num[2]);
        int res = 1;
        String arr[] = new String[n];
        for (int i = 0; i < n; n++) {
            String str = scanner.next();
            while (str.length() != m) {
                str = scanner.next();
            }
            arr[i] = str;
        }
        if (k == 1) {
            return 1;
        } else {
            HashSet<Object> set = new HashSet<>();
            for (int i =0;i< arr.length;i++) {
                res++;
                for (int j=0;j<res;j++) {
                    set.add(arr[j].indexOf(j));
                    if (set.size()==k) {
                        return res;
                    }
                }
            }
            if (res < k) {
                return -1;
            }
            return -1;
        }
    }
}
