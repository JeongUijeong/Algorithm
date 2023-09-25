package algorithm.heap.이중우선순위큐;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>(((o1, o2) -> o2-o1));
        int cnt = 0;
        for(String op : operations){
            String[] s = op.split(" ");
            if(s[0].equals("I")){
                pQ.offer(Integer.parseInt(s[1]));
            } else if (s[0].equals("D")) {
                if(pQ.size() - cnt <=0){
                    continue;
                }
                if(s[1].equals("1")){
                    pQ.poll();
                }else{
                    cnt++;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        int len = pQ.size()-cnt;
        for(int i=0;i<len;i++){
            list.add(pQ.poll());
        }
        if(list.isEmpty()){
            return new int[]{0,0};
        }
        return new int[]{list.get(0), list.get(len-1)};
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(Arrays.toString(
            T.solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})));
        System.out.println(Arrays.toString(
            T.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})));
    }
}
