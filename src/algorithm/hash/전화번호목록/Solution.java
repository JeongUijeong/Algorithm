package algorithm.hash.전화번호목록;

import java.util.HashMap;

public class Solution {

    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String number : phone_book) {
            map.put(number, 0);
        }
        for (String key : map.keySet()) {
            for (int j = 0; j < key.length()-1; j++) {
                if (map.containsKey(key.substring(0, j+1))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(T.solution(new String[]{"123", "456", "789"}));
        System.out.println(T.solution(new String[]{"12", "123", "1235", "567", "88"}));
    }
}
