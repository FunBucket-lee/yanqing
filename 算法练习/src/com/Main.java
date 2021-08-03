package com;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 返回集合大小的最小值
     *
     * @param n long长整型
     * @return int整型
     */
    public int getSize(long n) {
        if (n == 1) {
            return 1;
        }
        Set set = new HashSet();
        // write code here
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if ((i - j) == 0) {
                    set.add(j);
                }
            }
        }
        return set.size();
    }
}