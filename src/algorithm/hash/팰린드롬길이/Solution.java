package algorithm.hash.팰린드롬길이;

import java.util.HashMap;

class Solution {

    public int solution(String s) {
        int answer = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        boolean flag = false;
        for (char c : map.keySet()) {
            if (map.get(c) % 2 != 0) {
                answer--;
            } else {
                flag = true;
            }
        }
        if(flag){
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("abcbbbccaaeee"));
        System.out.println(T.solution("aabbccddee"));
        System.out.println(T.solution("fgfgabtetaaaetytceefcecekefefkccckbsgaafffg"));
        System.out.println(T.solution("aabcefagcefbcabbcc"));
        System.out.println(T.solution("abcbbbccaa"));
    }
}
