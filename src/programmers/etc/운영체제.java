package programmers.etc;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class 운영체제 {
    public static void main(String[] args) {
        int[][] program = {{2, 0, 10}, {1, 5, 5}, {3, 5, 3}, {3, 12, 2}};
        long[] answer = solution(program);
        System.out.println(Arrays.toString(answer));
    }

    public static long[] solution(int[][] program) {
        long[] answer = new long[11];

        Queue<int[]> queue = new PriorityQueue<>((i1, i2) -> {
            if(i1[0]==i2[0]){
                return i1[1]-i2[1];
            }
            return i1[0]-i2[0];
        });

        Arrays.sort(program, (i1, i2) -> {
            if(i1[1]==i2[1]){
                return i1[0]-i2[0];
            }
            return i1[1]-i2[1];
        });

        int index = 0;
        queue.add(program[index++]);

        long time = 0;

        while(!queue.isEmpty()){
            while(index<program.length && program[index][1]<=time){
                queue.add(program[index++]);
            }

            int[] temp = queue.poll();

            if(time<temp[1]){
                time = (long)temp[1]+(long)temp[2];
            }else{
                answer[temp[0]] += time-(long)temp[1];
                time += temp[2];
            }

            if(index<program.length && queue.isEmpty()) queue.add(program[index++]);
        }

        answer[0] = time;

        return answer;
    }
}
