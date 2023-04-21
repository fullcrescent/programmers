package programmers.level2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class 요격_시스템 {
     public static void main(String[] args){
         int[][] targets = {{2,3},{2,3},{2,3}};
         int answer = solution(targets);
         System.out.println(answer);
     }

    public static int solution(int[][] targets){
         int count = 0;
         Queue<Section> queue = new PriorityQueue<>(Section::compare);
         Arrays.stream(targets).forEach(i -> queue.add(new Section(i[0], i[1])));

         while(!queue.isEmpty()){
             Section section = queue.poll();

             while (!queue.isEmpty() && queue.peek().start<section.end) {
                queue.poll();
             }
             count++;
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
    }
}
