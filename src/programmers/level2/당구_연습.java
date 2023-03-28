package programmers.level2;

import java.util.Arrays;

public class 당구_연습 {
    public static void main(String[] args){
        int m = 10;
        int n = 10;
        int startX = 5;
        int startY = 7;
        int[][] balls = {{4, 7}};
        int[] answer = solution(m, n, startX, startY, balls);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        int index = 0;

        for(int[] ball : balls){
            answer[index++] = min(
                    cal(startX, startY, -ball[0], ball[1], m, n)
                    , cal(startX, startY, ball[0], -ball[1], m, n)
                    , cal(startX, startY, ball[0] + 2*(m-ball[0]), ball[1], m, n)
                    , cal(startX, startY, ball[0], ball[1] + 2*(n-ball[1]), m, n));
        }

        return answer;
    }

    private static int cal(int startX, int startY, int x, int y, int m, int n) {
        if((startX==x && (y<0 ? Math.abs(y)<startY : startY<Math.abs(y-2*n))) || (startY==y && (x<0 ? Math.abs(x)<startX : startX<Math.abs(x-2*m)))) {
            return Integer.MAX_VALUE;
        }

        return (int) (Math.pow(startX-x, 2) + Math.pow(startY-y, 2));
    }

    private static int min(int a, int b, int c, int d){
        return Math.min(a, Math.min(b, Math.min(c, d)));
    }
}
