package algorithm.simulation.키패드누르기;

public class Solution {

    public String solution(int[] numbers, String hand) {
        StringBuffer sb = new StringBuffer();
        int left = 10;
        int right = 12;

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i] == 0 ? 11 : numbers[i];

            switch (numbers[i]) {
                case 1:
                case 4:
                case 7:
                    sb.append("L");
                    left = numbers[i];
                    break;
                case 3:
                case 6:
                case 9:
                    sb.append("R");
                    right = numbers[i];
                    break;
                default:
                    int leftDistance = 0;
                    int rightDistance = 0;

                    if (left == 0) {
                        left = 11;
                    } else if (right == 0) {
                        right = 11;
                    }

                    leftDistance = (Math.abs(number - left) / 3) + (Math.abs(number - left) % 3);
                    rightDistance = (Math.abs(number - right) / 3) + (Math.abs(number - right) % 3);

                    if (leftDistance < rightDistance) {
                        sb.append("L");
                        left = numbers[i];
                    } else if (leftDistance > rightDistance) {
                        sb.append("R");
                        right = numbers[i];
                    } else {
                        if ("left".equals(hand)) {
                            sb.append("L");
                            left = numbers[i];
                        } else {
                            sb.append("R");
                            right = numbers[i];
                        }
                    }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(T.solution(numbers, hand));
    }
}
