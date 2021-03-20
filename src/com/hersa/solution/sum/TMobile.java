package com.hersa.solution.sum;

import java.util.Locale;

public class TMobile {

    public static void main(String[] args){
//        encryptWords("vywza xyzab");

        System.out.println(encryptWords("abcde")) ;
    }

    private static String encryptWords(String s){
        /*
        * split the string into an array of words.
        *
        * iterate through all words and encrypt them.
        *
        * */

        // find ecrypted values
        String alpha = "abcdefghijklmnopqrstuvwxyz";


        String[] arr = s.toLowerCase().split(" ");
        StringBuilder encrypted = new StringBuilder();

        for(int i = 0; i < arr.length; i++){
            // use sb to store encrypted word value
            StringBuilder sb = new StringBuilder();

            // get the next word
            String word = arr[i];
            String[] wa = word.split("");

            // iterate through word chars from the right
            for (int j = wa.length - 1 ; j >= 0; j--){
                // get the char
                String c = wa[j];

                int offset = wa.length - (j + 1);

                // calc index of the new letter
                int index = alpha.indexOf(c) + offset;

                // offset if > than 26
                index = index >= 26 ? index - 26 : index;

                String encLetter = String.valueOf(alpha.charAt(index));

                sb.append(encLetter);

            }

            encrypted.append(sb.reverse() + " ");
        }

        return encrypted.toString().trim();
    }
}
