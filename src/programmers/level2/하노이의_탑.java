package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 하노이의_탑 {
    public static void main(String[] args){
        int n = 3;
        int[][] answer = solution(n);
        Arrays.stream(answer).forEach(i -> System.out.println(Arrays.toString(i)));
    }

    public static int[][] solution(int n) {
        List<int[]> list = new ArrayList<>();
        function(n, 1, 2, 3, list);
        return list.toArray(int[][]::new);
    }

    private static void function(int n, int start, int mid, int end, List<int[]> answer) {
        if(n==1){
            answer.add(new int[] {start, end});
        }else{
            function(n-1, start, end, mid, answer);
            answer.add(new int[] {start, end});
            function(n-1, mid, start, end, answer);
        }
    }
}
