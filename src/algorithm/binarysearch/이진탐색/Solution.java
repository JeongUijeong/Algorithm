package algorithm.binarysearch.이진탐색;

import java.util.Arrays;

class Solution {

    public int solution(int[] nums, int target) {
        int answer = -1;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = 1 + ((right - left) / 2);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{2, 5, 7, 8, 10, 15, 20, 24, 25, 30}, 8));
        System.out.println(T.solution(new int[]{-3, 0, 2, 5, 8, 9, 12, 15}, 0));
    }
}
