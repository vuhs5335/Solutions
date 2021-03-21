package com.hersa.solution.sum;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {

    public static void main(String[] args){
        System.out.println(longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        Boolean[][] dp = new Boolean[n][n];
        String result = "";

        /*
            1. starts from the right at the same point for i and j
                - compare if both elements are the same, and store result.
                - for first comparison, you will be comparing same char, this will alwqays be true.
            2. Move j to the right and compare.
        */
        for (int i = n - 1; i >= 0; i --) {
            for (int j = i; j < n; j ++) {
                            /*
                                condition:
                                1. (s.charAt(i) == s.charAt(j))
                                    - the values are the same.
                               2.  (i + 2 >= j || dp[i + 1][j - 1])
                                    - i + 2 >= j
                                        -
                                    - dp[i + 1][j - 1]
                                        - previous condition prevents this from being out of bounds.
                            * */
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (i + 2 >= j || dp[i + 1][j - 1]);
                if (dp[i][j] && result.length() < j - i + 1) {
                    result = s.substring(i, j + 1);
                }
            }
        }
        return result;
    }

    public static String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
        }
        return R - L - 1;
    }
}
