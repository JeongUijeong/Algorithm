package algorithm.stackqueue.다리를지나는트럭;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> waitQ = new LinkedList<>();
        Queue<int[]> processQ = new LinkedList<>();
        Queue<Integer> completeQ = new LinkedList<>();
        for (int truck : truck_weights) {
            waitQ.offer(truck);
        }
        int cnt = 0;
        int cWeight = 0;
        while (completeQ.size() < truck_weights.length) {
            if (!processQ.isEmpty()) {
                int len = processQ.size();
                for (int i = 0; i < len; i++) {
                    int[] tmp = processQ.poll();
                    tmp[1]++;
                    if (tmp[1] == bridge_length) {
                        completeQ.offer(tmp[0]);
                        cWeight -= tmp[0];
                    } else {
                        processQ.offer(tmp);
                    }
                }
            }
            if (!waitQ.isEmpty() && cWeight + waitQ.peek() <= weight) {
                int startTmp = waitQ.poll();
                processQ.offer(new int[]{startTmp, 0});
                cWeight += startTmp;
            }
            cnt++;
        }
        return cnt;
    }

    public int solution2(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        int answer = 0, cWeight = 0, truckCnt = 0;
        while (!bridge.isEmpty()) {
            int tmp = bridge.poll();
            if (tmp != 0) {
                cWeight -= tmp;
            }
            if (truckCnt < truck_weights.length && cWeight + truck_weights[truckCnt] <= weight) {
                bridge.offer(truck_weights[truckCnt]);
                cWeight += truck_weights[truckCnt];
                truckCnt++;
            } else if (truckCnt < truck_weights.length){
                bridge.offer(0);
            }
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(T.solution(100, 100, new int[]{10}));
        System.out.println(T.solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
        System.out.println();
        System.out.println(T.solution2(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(T.solution2(100, 100, new int[]{10}));
        System.out.println(
            T.solution2(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }
}
