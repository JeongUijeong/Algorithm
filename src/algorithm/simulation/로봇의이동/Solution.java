package algorithm.simulation.로봇의이동;

import java.util.Arrays;

class Solution {

    public int[] solution(String moves) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int r = 0, c = 0;
        int d = 1; // 바라보는 방향
        for (char command : moves.toCharArray()) {
            if (command == 'R') {
                d = (d + 1) % 4; // 시계방향
            } else if (command == 'L') {
                d = (d + 3) % 4; // 반시계 방향
            } else if (command == 'G') {
                r = r + dr[d];
                c = c + dc[d];
            }
        }
        return new int[]{r, c};
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution("GGGRGGG")));
        System.out.println(Arrays.toString(T.solution("GGRGGG")));
        System.out.println(Arrays.toString(T.solution("GGGGGGGRGGGRGGRGGGLGGG")));
        System.out.println(Arrays.toString(T.solution("GGLLLGLGGG")));
    }
}
