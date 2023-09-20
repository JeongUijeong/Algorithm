package algorithm.simulation.청소로봇1;

import java.util.Arrays;

class Solution {

    public int[] solution(String moves) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int[] dir = {'U', 'R', 'D', 'L'};
        int r = 0;
        int c = 0;
        for (char command : moves.toCharArray()) {
            for (int i = 0; i < 4; i++) {
                if (command == dir[i]) {
                    r = r + dr[i];
                    c = c + dc[i];
                }
            }
        }
        return new int[]{r, c};
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution("RRRDDDLU")));
        System.out.println(Arrays.toString(T.solution("DDDRRRDDLL")));
        System.out.println(Arrays.toString(T.solution("RRRRRRDDDDDDUULLL")));
        System.out.println(Arrays.toString(T.solution("RRRRDDDRRDDLLUU")));
    }
}
