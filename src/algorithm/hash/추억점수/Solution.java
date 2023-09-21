package algorithm.hash.추억점수;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        for (int i = 0; i < photo.length; i++) {
            int score = 0;
            for (String n : photo[i]) {
                if (map.get(n) != null) {
                    score += map.get(n);
                }
            }
            answer[i] = score;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"},
            {"kon", "kain", "may", "coni"}};
        System.out.println(Arrays.toString(T.solution(name, yearning, photo)));
    }
}
