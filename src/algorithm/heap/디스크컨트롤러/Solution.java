package algorithm.heap.디스크컨트롤러;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {

    public int solution(int[][] jobs) {
        int cTime = 0, jCnt = 0, sum = 0;
        HashMap<Integer, int[]> hm = new HashMap<>();
        for (int i = 0; i < jobs.length; i++) {
            hm.put(i, jobs[i]);
        }
        while (jCnt < jobs.length) {
            PriorityQueue<int[]> pQ = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
            for (int i : hm.keySet()) {
                int[] tmp = hm.get(i);
                if (tmp[0] <= cTime) {
                    pQ.offer(new int[]{i, tmp[0], tmp[1]});
                }
            }
            if (!pQ.isEmpty()) {
                int[] p = pQ.poll();
                hm.remove(p[0]);
                jCnt++;
                cTime += p[2];
                sum += cTime - p[1];
            } else {
                cTime++;
            }
        }
        return sum / jobs.length;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));
    }
}
