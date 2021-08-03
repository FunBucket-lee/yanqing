package com;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/*有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），
        凡报到3的人退出圈子，问最后留下的是原来第几号的那位。*/

public class ThreeOut {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 1;
        int num = scanner.nextInt();
        List list = new ArrayList();
        for (int i = 0; i < num; i++) {
            list.add(i + 1);
        }

        ListIterator listIterator;

        while (list.size() > 1) {
            listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                int next = (int) listIterator.next();
                if (count++ % 3 == 0) {
                    System.out.println(next);
                    listIterator.remove();
                    count = 1;
                }
            }
        }
        System.out.println(list.get(0));
    }
}

