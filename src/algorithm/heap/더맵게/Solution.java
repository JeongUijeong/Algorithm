package algorithm.heap.더맵게;

import java.util.PriorityQueue;

public class Solution {

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for(int scov : scoville){
            pQ.offer(scov);
        }
        int answer = 0;
        while(pQ.peek()<K){
            if(pQ.size()<2){
                return -1;
            }
            int tmp = pQ.poll()+pQ.poll()*2;
            pQ.offer(tmp);
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }
}
