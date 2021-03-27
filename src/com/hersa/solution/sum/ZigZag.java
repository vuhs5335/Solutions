package com.hersa.solution.sum;

public class ZigZag {

    public static void main(String[] args){
        System.out.println(convert("PAYPALISHIRING", 5));
    }

    public static String convert(String s, int numRows){

        for (int i = 0; i < numRows ; i++) {

            int nth = (numRows - i) + (numRows - i - 2);

            int global = (i * 2) + nth;

            // mirror the nths after half
            nth = i >= ((global / 2) - 1) ? global - nth : nth;

            //System.out.println(nth);

            int p = i;

            while (p < s.length()){

                // print p
                System.out.println(s.charAt(p));

                //int vIndex = p + 1;

                //int sub = vIndex == nth ? 0 : ((global - nth) % (global / (vIndex - nth))) * 2;

                int sub = ((p % nth) + (global % nth)) * 2;

                // calc next
                p += nth - sub;

            }

        }
        return "";
    }
    public static String converts(String s, int numRows){
        /*
        *  1. Figure out the size of a 2D array to
        *     hold the zig zag value.
        *  2. To calculate the colums, we think about the
        *     segments as triangles, each with top
        *     side of length numRows
        * */

        //int m = i % numRows;

        //int nth = (numRows - (i % numRows)) + (numRows - (i % numRows) - 2);

        // if you have only one row or if the numrows is the length of the
        // string, the string will read the same.
        if(numRows == 1 || numRows >= s.length()){
            return s;
        }

        int cols = 0;

        if(numRows == 2){

            cols = (int) Math.ceil(Double.valueOf(s.length()) / 2);

        } else{
            int len = s.length();

            int count = 0;

            while(len > 0){

                int diff = 6;

                diff = diff > len ? len : diff;

                len -= diff;

                if(len < 0){
                    break;
                }

                count++;
            }

            cols = count * (numRows - 1);
        }


        return "";
    }
}
