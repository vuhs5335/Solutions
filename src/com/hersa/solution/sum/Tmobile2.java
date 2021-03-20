package com.hersa.solution.sum;

import java.util.*;
import java.util.stream.Collectors;

public class Tmobile2 {

    public static void main(String[] args){
        int[] a = {4,1,2,3,4,5};

        List<Integer> j = sort(a, 6);

        int ad = 9;
    }

    public static List<Integer> sort(int arr[], int size){

        List<Integer> solution = new ArrayList<Integer>();

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i <  arr.length; i++) {
            int a =  arr[i];

            if(!map.containsKey(a)){
                map.put(a, 0);
            }

            int count = map.get(a);

            count++;

            map.put(a, count);
        }

        sortByValue(map).forEach((key, value) -> {
            while(value > 0){
                solution.add(key);
                value--;
            }
        });

        return solution;
    }

    private static Map<Integer, Integer> sortByValue(Map<Integer, Integer> unsortMap) {

        List<Map.Entry<Integer, Integer>> list =
                new LinkedList<Map.Entry<Integer, Integer>>(unsortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}
