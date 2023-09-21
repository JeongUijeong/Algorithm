package algorithm.hash.한번만등장한문자;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        ArrayList<Character> list = new ArrayList<>();
        for(char c : map.keySet()){
            if(map.get(c) == 1){
                list.add(c);
            }
        }
        char[] arr = new char[list.size()];
        for(int i =0;i< list.size();i++){
            arr[i] = list.get(i);
        }
        Arrays.sort(arr);
        for(char c : arr){
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String s = "abcabcadc";
        System.out.println(T.solution(s));
        s = "abdc";
        System.out.println(T.solution(s));
        s = "hello";
        System.out.println(T.solution(s));
    }
}
