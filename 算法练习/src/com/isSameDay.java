package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class isSameDay {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            String[] temp = br.readLine().trim().split(" ");
            int[] date = Arrays.stream(temp).mapToInt(Integer::parseInt).toArray();
            System.out.println(countDays(date[0], date[1], date[2], date[3], date[4], date[5]));;
        }
    }

    public static String countDays(int y1, int m1, int d1, int y2, int m2, int d2) {
        int d1PassedDays = d1, d2PassedDays = d2;

        d1PassedDays = getD1PassedDays(y1, m1, d1PassedDays);
        d2PassedDays = getD1PassedDays(y2, m2, d2PassedDays);

        d1PassedDays += (y1-1) * 365 + (y1-1) / 4 - (y1-1) / 100 + (y1-1) / 400;
        d2PassedDays += (y2-1) * 365 + (y2-1) / 4 - (y2-1) / 100 + (y2-1) / 400;

        if(y1==1970&&m1==1&&(d1==1||d1==2||d1==3)){
            d1PassedDays++;
        }

        if ((d2PassedDays - d1PassedDays) % 7 == 0){
            return "True";
        } else {
            return "False";
        }
    }

    private static int getD1PassedDays(int y1, int m1, int passedDays) {
        int[] normalMonths = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] leapMonths = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if ((y1 % 4 == 0 && y1 % 100 != 0) || y1 % 400 == 0) {
            for (int i = 1; i < m1; i++) {
                passedDays += leapMonths[i];
            }
        } else {
            for (int i = 1; i < m1; i++) {
                passedDays += normalMonths[i];
            }
        }
        return passedDays;
    }
}