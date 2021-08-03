package com;

import java.util.Scanner;

public class MaxHeight {
    //一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在第n次落地时，
    // 共经过多少米？第n次反弹多高？（n<=10）
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        float ans1 = 0, ans2= 100.0F;
        for (int i = 1; i <= num; i++) {
            ans1 += ans2;
            ans2 = ans2 / 2;
        }
        System.out.println(ans1 + " " + ans2);
    }
}
