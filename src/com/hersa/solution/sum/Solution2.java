package com.hersa.solution.sum;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

        public static void main(String[] args){
            System.out.println(lengthOfLongestSubstring(""));
            int d = 7;
        }
        public static int lengthOfLongestSubstring(String s) {
            if("".equals(s)){
                return 0;
            }

            List<Character> strings = new ArrayList<Character>();

            int longest = 0;
            int count = 0;

            /* dvdf
            *  abcabcbb*/
            for(int i = 0; i < s.length() ; i++){

                Character v = s.charAt(i);

                // if contains , we need to set the index back to the initial occurance
                // and process from there. we start over from there.
                if(strings.contains(v)){

                    int index = s.substring(0 , i).lastIndexOf(v);

                    i = index;

                    count  = 0;


                    strings.clear();

                    continue;

                }

                strings.add(v);

                count++;

                if(count > longest){
                    longest = count;
                }

            }

            return longest;
        }
    }
