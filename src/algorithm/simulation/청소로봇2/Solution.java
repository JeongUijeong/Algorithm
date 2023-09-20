package algorithm.simulation.청소로봇2;

import java.util.Arrays;

class Solution {

    public int[] solution(int n, String moves) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int[] dir = {'U', 'R', 'D', 'L'};
        int r = 0;
        int c = 0;
        for (char command : moves.toCharArray()) {
            for (int i = 0; i < 4; i++) {
                if (command == dir[i]) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                        continue;
                    }
                    r = nr;
                    c = nc;
                }
            }
        }
        return new int[]{r, c};
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(5, "RRRDDDUUUUUUL")));
        System.out.println(Arrays.toString(T.solution(7, "DDDRRRDDLL")));
        System.out.println(Arrays.toString(T.solution(5, "RRRRRDDDDDU")));
        System.out.println(Arrays.toString(T.solution(6, "RRRRDDDRRDDLLUU")));
    }
}
