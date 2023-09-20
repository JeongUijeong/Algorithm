package algorithm.sortapplication.국영수;

import java.util.Arrays;
import java.util.Scanner;

// 문제 링크 : https://www.acmicpc.net/problem/10825
public class Main {

    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N; // 학생 수
    static Elem[] a; // 원소 배열

    static void input() {
        N = scan.nextInt();
        a = new Elem[N];
        for (int i = 0; i < N; i++) {
            a[i] = new Elem();
            a[i].name = scan.next();
            a[i].korean = scan.nextInt();
            a[i].english = scan.nextInt();
            a[i].math = scan.nextInt();
        }
    }

    static class Elem implements Comparable<Elem> {

        public String name;
        public int korean, english, math;

        @Override
        public int compareTo(Elem other) {
            // 국어 점수 내림차순
            if (korean != other.korean) {
                return other.korean - korean;
            }
            // 영어 점수 오름차순
            if (english != other.english) {
                return english - other.english;
            }
            // 수학 점수 내림차순
            if (math != other.math) {
                return other.math - math;
            }
            return name.compareTo(other.name);
        }
    }

    static void pro() {
        // 기준을 통해 정렬한다.
        Arrays.sort(a);

        // 정답을 출력한다.
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i].name).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        // 입력 받는다.
        input();

        // 정렬하고 출력한다.
        pro();
    }
}
