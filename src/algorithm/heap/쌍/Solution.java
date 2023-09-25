package algorithm.heap.쌍;

import java.util.PriorityQueue;

public class Solution {

    public void solution(int[][] nums) {
        PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[1] == b[1] ?
            a[0] - b[0] : a[1] - b[1]);
        for (int[] x : nums) {
            pQ.add(new int[]{x[0], x[1]});
        }
        int[] tmp = pQ.poll();
        System.out.println(tmp[0] + " " + tmp[1]);
        tmp = pQ.poll();
        System.out.println(tmp[0] + " " + tmp[1]);
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        T.solution(new int[][]{{10, 7}, {30, 3}, {10, 3}, {30, 10}, {12, 2}});
    }
}
