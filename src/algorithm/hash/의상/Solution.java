package algorithm.hash.의상;

import java.util.HashMap;

public class Solution {

    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] c : clothes) {
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        }
        int answer = 1;
        for (String s : map.keySet()) {
            answer *= map.get(s) + 1;
        }
        return answer - 1;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(
            new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}}));
        System.out.println(T.solution(
            new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"},
                {"smoky_makeup", "face"}}));
    }
}
