package algorithm.dfsbfs.게임맵최단거리;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int solution(int[][] maps) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int n = maps.length;
        int m = maps[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        maps[0][0] = 0;
        int level = 1;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] p = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nr = p[0] + dr[j];
                    int nc = p[1] + dc[j];
                    if (nr == n - 1 && nc == m - 1) {
                        return level + 1;
                    }
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && maps[nr][nc] == 1) {
                        q.offer(new int[]{nr, nc});
                        maps[nr][nc] = 0;
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(
            new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}}));
    }
}
