package algorithm.hash.베스트앨범;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {

    class Music {

        public int idx;
        public String genre;
        public int plays;
        public int sum;

        public Music(int idx, String genre, int plays, int sum) {
            this.idx = idx;
            this.genre = genre;
            this.plays = plays;
            this.sum = sum;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        // 장르별 총 재생 횟수
        HashMap<String, Integer> gSum = new HashMap<>();
        Music[] music = new Music[genres.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            gSum.put(genres[i], gSum.getOrDefault(genres[i], 0) + plays[i]);
        }
        // 음악 배열
        for (int i = 0; i < genres.length; i++) {
            music[i] = new Music(i, genres[i], plays[i], gSum.get(genres[i]));
        }
        // 정렬
        Arrays.sort(music, (o1, o2) -> (o2.sum - o1.sum));
        Arrays.sort(music, (o1, o2) -> {
            if ((o1.sum == o2.sum) && (o1.plays == o2.plays)) {
                return o1.idx - o2.idx;
            } else if ((o1.sum == o2.sum)) {
                return o2.plays - o1.plays;
            } else {
                return o2.sum - o1.sum;
            }
        });
        // 장르마다 2개씩 선정
        int cnt = 0;
        String genre = music[0].genre;
        for (Music m : music) {
            if (cnt < 2 && m.genre.equals(genre)) {
                list.add(m.idx);
                cnt++;
            } else if (!m.genre.equals(genre)) {
                genre = m.genre;
                list.add(m.idx);
                cnt = 1;
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(Arrays.toString(
            T.solution(new String[]{"classic", "pop", "classic", "classic", "pop"},
                new int[]{500, 600, 150, 800, 2500})));
    }
}
