package algorithm.stackqueue.주식가격;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<int[]> stack = new Stack<>();
        for(int i=0;i<prices.length;i++){
            while(!stack.isEmpty()&&prices[i]<stack.peek()[1]){
                int[] tmp = stack.pop();
                answer[tmp[0]] =i-tmp[0];
            }
            stack.add(new int[]{i,prices[i]});
        }
        while(!stack.isEmpty()){
            int[] tmp = stack.pop();
            answer[tmp[0]] = prices.length-1-tmp[0];
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 2, 3})));
    }
}
