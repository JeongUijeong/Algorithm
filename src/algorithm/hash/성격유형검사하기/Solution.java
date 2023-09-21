package algorithm.hash.성격유형검사하기;

import java.util.HashMap;

public class Solution {

    public char test(HashMap<Character, Integer> map, char a, char b) {
        if (map.getOrDefault(a, 0) > map.getOrDefault(b, 0)) {
            return a;
        } else if (map.getOrDefault(a, 0) < map.getOrDefault(b, 0)) {
            return b;
        } else {
            return a < b ? a : b;
        }
    }

    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < survey.length; i++) {
            char[] arr = survey[i].toCharArray();
            switch (choices[i]) {
                case 1:
                    map.put(arr[0], map.getOrDefault(arr[0], 0) + 3);
                    break;
                case 2:
                    map.put(arr[0], map.getOrDefault(arr[0], 0) + 2);
                    break;
                case 3:
                    map.put(arr[0], map.getOrDefault(arr[0], 0) + 1);
                    break;
                case 5:
                    map.put(arr[1], map.getOrDefault(arr[1], 0) + 1);
                    break;
                case 6:
                    map.put(arr[1], map.getOrDefault(arr[1], 0) + 2);
                    break;
                case 7:
                    map.put(arr[1], map.getOrDefault(arr[1], 0) + 3);
                    break;
            }
        }

        sb.append(test(map, 'R', 'T'));
        sb.append(test(map, 'C', 'F'));
        sb.append(test(map, 'J', 'M'));
        sb.append(test(map, 'A', 'N'));

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        System.out.println(T.solution(survey, choices));
    }
}
