package algorithm.hash.신고결과받기;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        //피신고자, 신고자들 해시맵. HashSet 사용해 중복 제거.
        Map<String, HashSet<String>> reportMap = new HashMap<>();
        HashSet<String> reportedID  = new HashSet<>();
        String[] reported = {};
        for(int i=0;i<report.length;i++) {
            reported = report[i].split(" ");
            if(reportMap.get(reported[1])==null){
                reportMap.put(reported[1], new HashSet<String>());
            }
            HashSet<String> set = reportMap.get(reported[1]);
            set.add(reported[0]);
            reportMap.put(reported[1], set);
        }

        //신고자, 메일 수신 배열 인덱스 해시맵
        Map<String, Integer> reporterIndexMap = new HashMap<>();
        for(int i=0;i<id_list.length;i++){
            reporterIndexMap.put(id_list[i], i);
        }

        //신고 당한 횟수가 k보다 많은 건에 대해 신고자에게 메일 발송
        for(int i=0;i<id_list.length;i++){
            Set<String> reporters = reportMap.get(id_list[i]);
            if(reporters != null && reporters.size() >= k){
                for (String reporter : reporters){
                    answer[reporterIndexMap.get(reporter)]++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        System.out.println(Arrays.toString(T.solution(id_list, report, k)));
    }
}
