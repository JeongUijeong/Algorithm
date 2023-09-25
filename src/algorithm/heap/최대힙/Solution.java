package algorithm.heap.최대힙;

import java.util.PriorityQueue;

class Solution {

    public void solution(int[] nums) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>((a, b) -> b - a);
        for (int x : nums) {
            pQ.add(x);
        }
        System.out.println(pQ.poll());
        System.out.println(pQ.poll());
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        T.solution(new int[]{15, 3, 5, 8, 10, 12, 20});
    }
}
