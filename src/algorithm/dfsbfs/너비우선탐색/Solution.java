package algorithm.dfsbfs.너비우선탐색;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public void BFS() {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(1);
        int level = 0; // 레벨
        while (!Q.isEmpty()) {
            int n = Q.size(); // 현 레벨에 있는 노드 개수
            System.out.print(level + " : ");
            for (int i = 0; i < n; i++) {
                int v = Q.poll();
                System.out.print(v + " ");
                for (int nv : new int[]{v * 2, v * 2 + 1}) {
                    if (nv > 7) {
                        continue;
                    }
                    Q.add(nv);
                }
            }
            level++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        T.BFS();
    }
}
