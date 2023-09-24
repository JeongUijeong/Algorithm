package algorithm.stackqueue.올바른괄호;

import java.util.Stack;

public class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(stack.isEmpty()){
                if(c==')'){
                    answer = false;
                    break;
                }
                stack.push(c);
            }else if(c=='('){
                stack.push(c);
            }else{
                if(stack.peek()=='('){
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty()){
            answer = false;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("()()"));
        System.out.println(T.solution("(())()"));
        System.out.println(T.solution(")()("));
        System.out.println(T.solution("(()("));
    }
}
