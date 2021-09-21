package com.trees;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }

    private static int fibonacci(int n) {
        int[] fibonacciNumbers = new int[n + 1];

        fibonacciNumbers[0] = 0;
        fibonacciNumbers[1] = 1;

        for(int i = 2; i <= n; i++) {
            fibonacciNumbers[i] = fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2];
        }

        return fibonacciNumbers[n];
    }

}
