package main.edu.course1.week1;

import java.math.BigDecimal;

public class Multiplication {
    public static BigDecimal karatsuba (BigDecimal num1, BigDecimal  num2)
    {
        String num1str = String.format("%.0f", num1);
        String num2str = String.format("%.0f", num2)  ;

        int maxLength = Math.max(String.valueOf(num1).length(), String.valueOf(num2).length());
        int num1Size = String.valueOf(num1).length();
        int num2Size = String.valueOf(num2).length();
        int halfSize = maxLength / 2;
        int splitNum1 = num1Size - halfSize;
        int splitNum2 = num2Size - halfSize;
        if ( num1.compareTo(BigDecimal.TEN) == -1 || num2.compareTo(BigDecimal.TEN)==-1)
            return num1.multiply(num2);

        BigDecimal a = new BigDecimal(num1str.substring(0, splitNum1));
        BigDecimal b = new BigDecimal(num1str.substring(splitNum1));
        BigDecimal c = new BigDecimal(num2str.substring(0, splitNum2));
        BigDecimal d = new BigDecimal(num2str.substring(splitNum2));

        BigDecimal step1 = karatsuba(a, c);
        BigDecimal step2 = karatsuba(b, d);
        BigDecimal step3 = karatsuba(a.add(b), c.add(d));
        BigDecimal step4 = step3.subtract(step1).subtract(step2);

        BigDecimal step5 = (BigDecimal.valueOf(10).pow(halfSize)).multiply(step4);
        BigDecimal step6 = step1.multiply(new BigDecimal("10").pow(halfSize*2));

        return step2
                .add(step5)
                .add(step6);
    }
    public static void main(String[] args) {
        BigDecimal num1 = new BigDecimal(3141592653589793238462643383279502884197169399375105820974944592d);
        BigDecimal num2 = new BigDecimal(2718281828459045235360287471352662497757247093699959574966967627d);

//        BigDecimal num1 = new BigDecimal(5678);
//        BigDecimal num2 = new BigDecimal(1234);
        BigDecimal val = karatsuba(num1, num2);
        System.out.println(val);
    }
}
