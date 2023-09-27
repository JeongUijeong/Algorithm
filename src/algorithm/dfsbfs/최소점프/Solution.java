package algorithm.dfsbfs.최소점프;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int solution(int home) {
        Queue<Integer> q = new LinkedList<>();
        int[] check = new int[10001];
        q.offer(0);
        check[0] = 1;
        int level = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                int v = q.poll();
                for (int nv : new int[]{v - 1, v + 1, v + 5}) {
                    if (nv == home) {
                        return level + 1;
                    } else if (nv > 0 && nv <= 10000 && check[nv] == 0) {
                        check[nv] = 1;
                        q.add(nv);
                    }
                }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(10));
        System.out.println(T.solution(14));
        System.out.println(T.solution(25));
        System.out.println(T.solution(24));
        System.out.println(T.solution(345));
    }
}
