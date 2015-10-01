package com.shirish.test;

import java.util.ArrayList;

/**
 * Created by shirish on 12/23/14.
 */
public class FibonacciGenerator {


    public void generateFibonacci(int N){
        System.out.println("generating Fibonacci using ArrayList for " + N);
        ArrayList<Integer> fibList = new ArrayList<Integer>();

        fibList.add(0);
        fibList.add(1);

        for (int i = 2; i <= N; ++i) {
            Integer first = fibList.get(i-2);
            Integer second = fibList.get(i-1);
            fibList.add(first.intValue() + second.intValue());
        }

        for (Integer e : fibList){
            System.out.println(e);
        }
    }


    public void printFib(final int N) {
        System.out.println("generating Fibonacci for " + N);
        int f0 = 0;
        int f1 = 1;

        for (int i = 0; i <= N; ++i) {
            System.out.println(f0);
            final int temp = f1;
            f1 += f0;
            f0 = temp;
        }
    }


    public int fibonacci(int n)  {
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }


}
