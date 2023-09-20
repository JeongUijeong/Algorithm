package algorithm.simulation.웅덩이;

class Solution {

    public int solution(int[][] nums) {
        // 방향 배열
        int[] dr = {-1, 0, 1, 0}; // 8방향: {-1,-1,0,1,1,1,0,-1}
        int[] dc = {0, 1, 0, -1}; // 8방향: {0,1,1,1,0,-1,-1,-1}
        int answer = 0;
        int n = nums.length;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];
                    if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                        continue;
                    }
                    if (nums[nr][nc] <= nums[r][c]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(
            new int[][]{{10, 20, 50, 30, 20}, {20, 30, 50, 70, 90}, {10, 15, 25, 80, 35},
                {25, 35, 40, 55, 80}, {30, 20, 35, 40, 90}}));
        System.out.println(T.solution(
            new int[][]{{80, 25, 10, 65, 100}, {20, 10, 32, 70, 33}, {45, 10, 88, 9, 90},
                {10, 35, 10, 55, 66}, {10, 84, 65, 88, 99}}));
        System.out.println(T.solution(
            new int[][]{{33, 22, 55, 65, 55}, {55, 88, 99, 12, 19}, {18, 33, 25, 57, 77},
                {46, 78, 54, 55, 99}, {33, 25, 47, 85, 17}}));
    }
}