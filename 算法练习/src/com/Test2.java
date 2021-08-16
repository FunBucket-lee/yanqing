package com;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.next();
        int[] test = new int[2];
        test[0] = Integer.parseInt(String.valueOf(in.charAt(0)));
        test[1] = Integer.parseInt(String.valueOf(in.charAt(2)));
        String[] nm = new String[test[0]];
        for (int i = 0; i < test[0]; i++) {
            nm[i] = scanner.next();
        }
    }

    public static int Solution(){
        return 0;
    }
}

