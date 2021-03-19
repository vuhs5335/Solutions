package com.hersa.solution.sum;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void main(String[] args){
        //int[] a = {0,0};
        //int[] b = {0,0};

        int[] a = {1,3,5};
        int[] b = {4};

        System.out.println("The median is: " + findMedianSortedArrays(a, b));

    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int i = 0;
        int j = 0;

        List<Integer> solutions = new LinkedList<>();

        while (i < nums1.length && j < nums2.length){

            int n1 = nums1[i];
            int n2 = nums2[j];

            if(n1 < n2) {
                solutions.add(n1);
                i++;
            } else if(n1 > n2){
                solutions.add(n2);
                j++;
            }else{
                solutions.add(n1);
                solutions.add(n2);
                i++;
                j++;
            }
        }

        // check any unprocessed elements and add to list.
        // these will be in order.
        for (i = i; i < nums1.length; i++){
            solutions.add(nums1[i]);
        }

        for (j = j; j < nums2.length; j++){
            solutions.add(nums2[j]);
        }

        // find the median.
        double median;

        double size = solutions.size();

        // if we have an odd number of elements.
        if(solutions.size() % 2 != 0){
            double mid = Math.ceil(size / 2) - 1;
            median = solutions.get((int) mid);
        }else{
            double mid1 = solutions.get((int) Math.ceil(size / 2) - 1);
            double mid2 = solutions.get((int) Math.ceil(size / 2));
            median = (mid1 + mid2) / 2;
        }

        return median;
    }
}
