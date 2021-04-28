package ru.vsu.cs.KiselevaMaria;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        long x, y;
        Scanner scanner = new Scanner(System.in); {
            x = scanner.nextLong();
            y = scanner.nextLong();
        }
        long result = karatsuba(x, y);
        System.out.println(result);
    }

    private static long karatsuba(long x, long y) {
        if (x < 10 && y < 10)
            return x * y;

        int n = Math.max(Long.valueOf(x).toString().length(), (Long.valueOf(y).toString().length()));
        int m = n / 2 + n % 2;

        long a = x / (long) Math.pow(10, m);
        long b = x % (long) Math.pow(10, m);
        long c = y / (long) Math.pow(10, m);
        long d = y % (long) Math.pow(10, m);
        long step1 = karatsuba(a, c);
        long step2 = karatsuba(b, d);
        long step3 = karatsuba(a + b, c + d);
        long step4 = step3 - step2 - step1;
        long step5 = step1 * (long) Math.pow(10, m * 2) + step2 + step4 * (long) Math.pow(10, m);
        return step5;
    }

}

