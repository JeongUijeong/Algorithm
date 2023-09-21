package algorithm.hash.외톨이알파벳;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public String solution(String input_string) {
        String answer = "N";
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap();
        map.put(input_string.charAt(0), 1);
        for (int i = 1; i < input_string.length(); i++) {
            if (input_string.charAt(i - 1) != input_string.charAt(i)) {
                map.put(input_string.charAt(i), map.getOrDefault(input_string.charAt(i), 0) + 1);
            }

        }
        for (char c : map.keySet()) {
            if (map.get(c) >= 2) {
                sb.append(c);
            }

        }
        answer = sb.toString();
        if (answer.equals("")) {
            answer = "N";
        } else {
            char[] arr = answer.toCharArray();
            Arrays.sort(arr);
            answer = String.valueOf(arr);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String input_string = "edeaaabbccd";
        System.out.println(T.solution(input_string));
    }
}
