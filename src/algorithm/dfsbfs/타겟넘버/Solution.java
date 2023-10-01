package algorithm.dfsbfs.타겟넘버;

public class Solution {

    public int dfs(int[] numbers, int target, int sum, int cnt) {
        int result = 0;
        if (cnt == numbers.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        result += dfs(numbers, target, sum + numbers[cnt], cnt + 1);
        result += dfs(numbers, target, sum + numbers[cnt] * -1, cnt + 1);
        return result;
    }

    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(T.solution(new int[]{4, 1, 2, 1}, 2));
    }
}
