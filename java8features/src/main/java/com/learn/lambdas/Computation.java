package com.learn.lambdas;

public class Computation {

    public static void main(String[] args) {

        Calculation addition = new Calculation() {
            @Override
            public double compute(double num1, double num2) {
                return num1 + num2;
            }
        };

        System.out.println(addition.compute(10, 5));

        Calculation additionLambda = (num1, num2) -> num1 + num2;
        System.out.println(additionLambda.compute(20, 10));

        Calculation multiply = (n1, n2) -> n1 * n2;
        System.out.println(multiply.compute(5, 5));

        System.out.println(Calculation.performComputation(6, 5, multiply));
        System.out.println(Calculation.performComputation(6, 5, addition));
        System.out.println(Calculation.performComputation(2, 6, (n1, n2) -> Math.pow(n1, n2)));

    }
}
