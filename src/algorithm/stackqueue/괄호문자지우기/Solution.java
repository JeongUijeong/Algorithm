package algorithm.stackqueue.괄호문자지우기;

import java.util.Stack;

class Solution {

    public String solution(String str) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()){
            if(c == '('){
                stack.push(c);
            } else if(c == ')' && stack.peek() == '('){
                stack.pop();
            } else if(stack.isEmpty()){
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("(A(BC)D)EF(G(H)(IJ)K)LM(N)"));
    }
}
