package algorithm.binarysearch.랜선자르기;

class Solution {

    public int calc(int[] nums, long mid) {
        int cnt = 0;
        for (int num : nums) {
            cnt += num / (int) mid;
        }
        return cnt;
    }

    public int solution(int[] nums, int n) {
        int answer = 0;
        long left = 1;
        long right = 0;
        for (int num : nums) {
            right = Math.max(right, num);
        }
        while (left <= right) {
            long mid = (left + right) / 2;
            if (calc(nums, mid) >= n) {
                answer = (int) mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{802, 743, 457, 539}, 11));
        System.out.println(
            T.solution(new int[]{8593, 9617, 9313, 4513, 7505, 5457, 8257, 4689, 2657}, 100));
        System.out.println(T.solution(new int[]{93, 97, 93, 53, 75, 57, 85, 89, 67}, 30));
    }
}
