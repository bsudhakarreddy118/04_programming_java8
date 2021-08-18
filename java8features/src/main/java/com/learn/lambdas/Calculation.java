package com.learn.lambdas;

@FunctionalInterface
public interface Calculation {
    double compute(double num1, double num2);

    public static double performComputation(double num1, double num2, Calculation calculation){
        return calculation.compute(num1, num2);
    }

    default public void test(){
        System.out.println("Testing");
    }

}
