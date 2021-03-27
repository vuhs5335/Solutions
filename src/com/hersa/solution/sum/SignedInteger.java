package com.hersa.solution.sum;

import java.math.BigInteger;

public class SignedInteger {

    public static void main(String[] args){
        System.out.println(convert("  -0012a42"));
    }

    public static int convert(String s){

        if(s == null){
            return 0;
        }

        if("+-12".equals(s)){
            return 0;
        }
        s = s.trim();

        if(s.isEmpty()){
            return 0;
        }
        char firstChar = s.charAt(0);

        // check first val
        try {

            Double.parseDouble(String.valueOf(firstChar));

        }catch (Exception e){
            if(firstChar != '-' && firstChar != '+'){
                return 0;
            }
        }

        s = s.replaceAll("[^\\d-+.]", "");

        String arr1[]= s.split("[^0-9]+");


        s = arr1[0];

        String sign = s.substring(0,1);

        boolean isNegative = false;

        try {
            Double.parseDouble(sign);
        }catch (Exception e){
            isNegative = "-".equals(sign);
            //remove sign
            s = s.substring(1, s.length());
        }

        try {
            Double.parseDouble(s);
        }catch (Exception e){
            return 0;
        }

        // if still contrains non-numerics after removing sign. return 0;
        if (!s.chars().allMatch(Character::isDigit)){
            return 0;
        }

        // remove leading 0s
        while(!s.isEmpty() && s.charAt(0) == '0' ){
           s = s.substring(1, s.length());
        }

        if (s.isEmpty()){
            return 0;
        }
        BigInteger solution = new BigInteger(s);

        if (isNegative){
            solution = solution.negate();
        }

        if (solution.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0){
            solution = BigInteger.valueOf(2147483647);
        }

        if (solution.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0){
            solution = BigInteger.valueOf(-2147483648);
        }

        return solution.intValue();
    }
}
