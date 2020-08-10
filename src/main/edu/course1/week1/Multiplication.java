package main.edu.course1.week1;

import java.math.BigDecimal;

public class Multiplication {
    public static BigDecimal karatsuba (BigDecimal num1, BigDecimal  num2)
    {
        String num1str = String.format("%.0f", num1);
        String num2str = String.format("%.0f", num2)  ;
        int maxLength = Math.max(num1str.length(), num2str.length());

        if (num1str.length()==2 || num2str.length()==2)
            return num1.multiply(num2);
        int splitPosition = (maxLength/2 ) + (maxLength%2);
//        double a = Double.parseDouble(num1str.substring(0, splitPosition));
//        double b = Double.parseDouble(num1str.substring(splitPosition));
//        double c = Double.parseDouble(num2str.substring(0, splitPosition));
//        double d = Double.parseDouble(num2str.substring(splitPosition));

        BigDecimal a = new BigDecimal(num1str.substring(0, splitPosition));
        BigDecimal b = new BigDecimal(num1str.substring(splitPosition));
        BigDecimal c = new BigDecimal(num2str.substring(0, splitPosition));
        BigDecimal d = new BigDecimal(num2str.substring(splitPosition));

//        BigDecimal a = num1.divide(BigDecimal.valueOf(10).pow(splitPosition));
//        BigDecimal b = num1.remainder(BigDecimal.valueOf(10).pow(splitPosition));
//        BigDecimal c = num2.divide(BigDecimal.valueOf(10).pow(splitPosition));
//        BigDecimal d = num2.remainder(BigDecimal.valueOf(10).pow(splitPosition));

        BigDecimal step1 = karatsuba(a, c);
        BigDecimal step2 = karatsuba(b, d);
        BigDecimal step3 = karatsuba(a.add(b), c.add(d));
        BigDecimal step4 = step3.subtract(step1).subtract(step2);

        BigDecimal step5 = (BigDecimal.valueOf(10).pow(splitPosition)).multiply(step4);
        BigDecimal step6 = (BigDecimal.valueOf(10).pow(splitPosition*2)).multiply(step1);

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
