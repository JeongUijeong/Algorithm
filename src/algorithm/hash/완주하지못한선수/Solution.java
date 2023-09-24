package algorithm.hash.완주하지못한선수;

import java.util.HashMap;

public class Solution {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }
        for (String s : map.keySet()) {
            if (map.get(s) != 0) {
                answer = s;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(
            T.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
        System.out.println(T.solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},
            new String[]{"josipa", "filipa", "marina", "nikola"}));
        System.out.println(T.solution(new String[]{"mislav", "stanko", "mislav", "ana"},
            new String[]{"stanko", "ana", "mislav"}));
    }
}
