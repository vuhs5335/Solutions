package com.hersa.solution.sum;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ReverseInteger {

    public static void main(String[] args){
        reverse(-2147483648);
    }
    public static int reverse(int x) {

        BigInteger reversed = BigInteger.ZERO;

        int h = x * -1;

        while( h != 0){

            int digit = h % 10;

            reversed = (reversed.multiply(BigInteger.TEN)).add(BigInteger.valueOf(digit));

            if(reversed.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0){
                return 0;
            }

            h /= 10;
        }

        return reversed.intValue();
    }
}
