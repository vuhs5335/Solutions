package com.hersa.solution.sum;

import java.math.BigInteger;

public class IntPalindrome {

    public static void main(String[] args){
        boolean isPalindrome = isPalindrome(-101);
        System.out.println(isPalindrome);
    }

    private static boolean isPalindrome(int x) {

        BigInteger n = BigInteger.valueOf(x);

        String sNumber = n.toString();

        int s = 0;
        int e = sNumber.length() - 1;

        while(s < e){
            char a = sNumber.charAt(s);
            char b = sNumber.charAt(e);

            if(a != b){
                return false;
            }

            s++;
            e--;
        }
        return true;
    }
}
