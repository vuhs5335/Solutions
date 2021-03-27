package com.hersa.solution.sum;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ReverseInteger {

    public static void main(String[] args){
        System.out.println(reverse(-2147483648));

        //System.out.println(reverse(123));
      //  System.out.println(Integer.MAX_VALUE);
    }
    public static int reverse(int x) {

        BigInteger absValue = BigInteger.valueOf(x).abs();
        BigInteger maxValue = BigInteger.valueOf(Integer.MAX_VALUE);

        if (absValue.compareTo(maxValue) > 0){
            return 0;
        }

        BigInteger x1 = BigInteger.valueOf(x);

        BigInteger reversed = BigInteger.ZERO;

        while( x1.compareTo(BigInteger.ZERO) != 0){

            BigInteger digit = BigInteger.valueOf(x1.intValue() % 10);

            reversed = reversed.multiply(BigInteger.TEN).add(digit);

            if(reversed.abs().compareTo(maxValue) > 0){
                return 0;
            }

            x1 = x1.divide(BigInteger.TEN);
        }

        return reversed.intValue();
    }
}
