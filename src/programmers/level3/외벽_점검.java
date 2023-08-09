package programmers.level3;

import java.util.Arrays;


public class 외벽_점검 {
    public static void main(String[] args) {
        int n = 12;
        int[] weak = {1, 5, 6, 10};
        int[] dist = {1, 2, 4, 2};
        int answer = solution(n, weak, dist);
        System.out.println(answer);
    }

    public static int solution(int n, int[] weak, int[] dist) {
        Arrays.sort(dist);

        for(int i=dist.length-1; i>-1; i--){
            System.out.println(i);
        }

        return 1;
    }
}
