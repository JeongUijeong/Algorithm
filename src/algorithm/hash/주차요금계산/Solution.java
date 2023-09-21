package algorithm.hash.주차요금계산;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    public int getTime(String time) {
        return Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);
    }

    public int[] solution(int[] fees, String[] records) {
        HashMap<Integer, Integer> inTime = new HashMap<>();
        HashMap<Integer, Boolean> isOut = new HashMap<>();
        HashMap<Integer, Integer> sumTime = new HashMap<>();
        HashSet<Integer> carNum = new HashSet<>();

        for (String record : records) {
            String time = record.split(" ")[0];
            int num = Integer.parseInt(record.split(" ")[1]);
            String cnt = record.split(" ")[2];
            if (cnt.equals("IN")) {
                inTime.put(num, getTime(time));
                isOut.put(num, false);
                carNum.add(num);
            } else {
                sumTime.put(num, sumTime.getOrDefault(num, 0) + (getTime(time) - inTime.get(num)));
                isOut.put(num, true);
            }
        }
        for (int num : isOut.keySet()) {
            if (!isOut.get(num)) {
                sumTime.put(num, sumTime.getOrDefault(num, 0) + 23 * 60 + 59 - inTime.get(num));
            }
        }
        int[] carArr = new int[carNum.size()];
        int idx = 0;
        for(int num : carNum){
            carArr[idx] = num;
            idx++;
        }
        Arrays.sort(carArr);
        int[] answer = new int[carNum.size()];
        for (int i = 0; i < carNum.size(); i++) {
            if (sumTime.get(carArr[i]) <= fees[0]) {
                answer[i] = fees[1];
            } else {
                answer[i] = fees[1] + ((sumTime.get(carArr[i]) - fees[0]) / fees[2]) * fees[3];
                if ((sumTime.get(carArr[i]) - fees[0]) % fees[2] != 0) {
                    answer[i] += fees[3];
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT",
            "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(Arrays.toString(T.solution(fees, records)));
    }
}
