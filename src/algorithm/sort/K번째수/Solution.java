package algorithm.sort.K번째수;

import java.util.Arrays;

public class Solution {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] tmp = new int[commands[i][1] - commands[i][0] + 1];
            int idx = 0;
            for (int j = 0; j <= commands[i][1] - commands[i][0]; j++) {
                tmp[idx++] = array[commands[i][0] - 1 + j];
            }
            Arrays.sort(tmp);
            answer[i] = tmp[commands[i][2] - 1];
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 5, 2, 6, 3, 7, 4},
            new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})));
    }
}
