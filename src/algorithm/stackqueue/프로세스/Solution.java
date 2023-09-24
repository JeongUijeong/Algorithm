package algorithm.stackqueue.프로세스;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    class Process {

        public int idx;
        public int priority;

        public Process(int idx, int priority){
            this.idx = idx;
            this.priority = priority;
        }
    }

    public int solution(int[] priorities, int location) {
        Queue<Process> q = new LinkedList<>();
        for(int i = 0;i < priorities.length;i++){
            q.offer(new Process(i, priorities[i]));
        }
        int cnt = 0;
        while(!q.isEmpty()){
            Process p = q.poll();
            boolean flag = false;
            for(int i=0;i<q.size();i++){
                Process tmp = q.poll();
                if(p.priority < tmp.priority){
                    flag = true;
                }
                q.offer(tmp);
            }
            if(flag){
                q.offer(p);
            }else{
                cnt++;
                if(p.idx == location){
                    break;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(T.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }
}
