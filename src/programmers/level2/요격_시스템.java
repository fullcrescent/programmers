package programmers.level2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class 요격_시스템 {
     public static void main(String[] args){
         int[][] targets = {{0,4},{5,10},{6,8},{8,9}};
         int answer = solution(targets);
         System.out.println(answer);

         int[][] targets1 = {{0,4},{5,10},{6,8},{8,9}};
         int answer1 = solution1(targets1);
         System.out.println(answer1);
     }

    public static int solution(int[][] targets){
         int count = 0;
         Queue<Section> queue = new PriorityQueue<>(Section::compare);
         Arrays.stream(targets).forEach(i -> queue.add(new Section(i[0], i[1])));

         while(!queue.isEmpty()){
             Section section = queue.poll();

             while (!queue.isEmpty() && queue.peek().start<section.end) {
                 section.end = Math.min(section.end, queue.poll().end);
             }
             count++;
        }

        return count;
    }

    /*다른 사람의 풀이 참고*/
    public static int solution1(int[][] targets){
        int count = 0;
        Queue<Section> queue = new PriorityQueue<>(Section::compare1);
        Arrays.stream(targets).forEach(i -> queue.add(new Section(i[0], i[1])));

        int missile = 0;

        while(!queue.isEmpty()) {
            Section section = queue.poll();

            if(missile < section.start+1){
                missile = section.end;
                count++;
            }
        }

        return count;
    }

    static class Section{
         int start;
         int end;

        public Section(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public static int compare(Section s1, Section s2){
            return s1.start == s2.start ? Integer.compare(s1.end, s2.end) : Integer.compare(s1.start, s2.start);
        }

        public static int compare1(Section s1, Section s2){
            return Integer.compare(s1.end, s2.end);
        }
    }
}
