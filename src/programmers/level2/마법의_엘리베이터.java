package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class 마법의_엘리베이터 {
    public static void main(String[] args){
        int storey = 2554;
        int answer = solution(storey);
        System.out.println(answer);
    }

    public static int solution(int storey) {
        Queue<Test> queue = new LinkedList<>();
        queue.add(new Test(0, storey, 0));

        while(!queue.isEmpty()){
            Test temp = queue.poll();

            int digit = (int) (temp.value/Math.pow(10, temp.depth)%10);

            if(digit!=5){
                int add = Math.min(digit, digit-10);
                queue.add(new Test(temp.depth+1, temp.value+add, temp.count+add));
            }else{

            }

            System.out.println(digit);
        }


        return 0;
    }

    static class Test{
        int depth;
        int value;
        int count;

        public Test(int depth, int value, int count) {
            this.depth = depth;
            this.value = value;
            this.count = count;
        }
    }
}