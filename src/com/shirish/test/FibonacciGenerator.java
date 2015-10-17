/**
 The MIT License (MIT)

Copyright (c) 2015 Shirish Ranjit

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.

 */

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
