package algorithm.bruteforce.최소직사각형;

public class Solution {

    public int solution(int[][] sizes) {
        int w = 0;
        int h = 0;
        for (int[] arr : sizes) {
            if (arr[0] < arr[1]) {
                w = Math.max(w, arr[0]);
                h = Math.max(h, arr[1]);
            } else {
                w = Math.max(w, arr[1]);
                h = Math.max(h, arr[0]);
            }
        }
        return w * h;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
        System.out.println(T.solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}));
        System.out.println(T.solution(new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}));
    }
}
