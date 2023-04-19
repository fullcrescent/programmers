package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 마법의_엘리베이터 {
    public static void main(String[] args){
        int storey = 545;
        int answer = solution(storey);
        System.out.println(answer);
    }

    public static int solution(int storey) {
        int answer = Integer.MAX_VALUE;
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(0, storey, 0));

        while(!queue.isEmpty()){
            Info temp = queue.poll();

            if(temp.value==0){
                answer = Math.min(answer, temp.count);
                continue;
            }

            int digit = (int) (temp.value/Math.pow(10, temp.depth)%10);
            int add = digit<5 ? -digit : 10-digit;

            queue.add(new Info(temp.depth+1, temp.value+(int) (add*Math.pow(10, temp.depth)), temp.count+Math.abs(add)));

            if (digit == 5) {
                queue.add(new Info(temp.depth+1, temp.value-(int) (add*Math.pow(10, temp.depth)), temp.count+Math.abs(add)));
            }
        }

        return answer;
    }

    static class Info {
        int depth;
        int value;
        int count;

        public Info(int depth, int value, int count) {
            this.depth = depth;
            this.value = value;
            this.count = count;
        }
    }
}