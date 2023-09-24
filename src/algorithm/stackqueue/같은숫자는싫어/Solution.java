package algorithm.stackqueue.같은숫자는싫어;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i=arr.length-1;i>=0;i--) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
            } else if (stack.peek() != arr[i]) {
                stack.push(arr[i]);
            }
        }
        int[] answer = new int[stack.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = stack.pop();
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 3, 3, 0, 1, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{4, 4, 4, 3, 3})));
    }
}
