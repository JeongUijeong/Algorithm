package algorithm.hash.학급회장;

import java.util.HashMap;

class Solution {

    public char solution(String s) {
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int max = 0;
        for (char c : map.keySet()) {
            if (max < map.get(c)) {
                max = map.get(c);
                answer = c;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("BACBACCACCBDEDE"));
        System.out.println(T.solution("AAAAABBCCDDDD"));
        System.out.println(T.solution("AABBCCDDEEABCB"));
    }
}
