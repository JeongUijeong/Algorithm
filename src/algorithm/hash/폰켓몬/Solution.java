package algorithm.hash.폰켓몬;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        return Math.min(set.size(), nums.length / 2);
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{3, 1, 2, 3}));
        System.out.println(T.solution(new int[]{3, 3, 3, 2, 2, 4}));
        System.out.println(T.solution(new int[]{3, 3, 3, 2, 2, 2}));
    }
}
