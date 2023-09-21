package algorithm.hash.같은빈도수만들기;

import java.util.Arrays;
import java.util.HashMap;

class Solution {

    public int[] solution(String s) {
        int[] answer = new int[5];
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (max < map.get(c)) {
                max = map.get(c);
            }
        }
        int idx = 0;
        for (char c : "abcde".toCharArray()){
            answer[idx] = max - map.getOrDefault(c, 0);
            idx++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}
