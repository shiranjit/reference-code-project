package com.shirish.test;

import junit.framework.TestCase;

public class FibonacciGeneratorTest extends TestCase {

    public void testGenerateFibonacci() throws Exception {
        FibonacciGenerator fgen = new FibonacciGenerator();
        fgen.generateFibonacci(10);

    }

    public void testPrintFib() throws Exception {
        FibonacciGenerator fgen = new FibonacciGenerator();
        fgen.printFib(10);

    }

    public void testFibonacci() throws Exception {

        FibonacciGenerator fgen = new FibonacciGenerator();
        int fib = fgen.fibonacci(10);
        System.out.println("Fibonacci Gen number: " + fib);

    }
}