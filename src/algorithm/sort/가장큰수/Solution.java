package algorithm.sort.가장큰수;

import java.util.Arrays;

public class Solution {

    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        Integer[] nums = new Integer[numbers.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numbers[i];
        }
        Arrays.sort(nums, (o1, o2) -> {
            String tmp1 = o1.toString();
            String tmp2 = o2.toString();
            return Integer.parseInt(tmp2 + tmp1) - Integer.parseInt(tmp1 + tmp2);
        });
        for (int num : nums) {
            sb.append(num);
        }
        if(sb.toString().charAt(0)=='0'){
            return "0";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{6, 10, 2}));
        System.out.println(T.solution(new int[]{3, 30, 34, 5, 9}));
    }
}
