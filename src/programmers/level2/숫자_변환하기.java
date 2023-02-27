package programmers.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Function;

public class 숫자_변환하기 {
    public static void main(String[] args){
        int x = 10;
        int y = 33;
        int n = 5;
        int answer = solution(x, y, n);
        System.out.println(answer);
    }

    public static int solution(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, x});

        List<Function<Integer, Integer>> list = new ArrayList<>();
        list.add(i -> i*2);
        list.add(i -> i*3);
        list.add(i -> i+n);

        while(!queue.isEmpty()){
            int[] temp = queue.poll();

            if(temp[1]==y)  return temp[0];

            for(Function<Integer, Integer> f : list){
                int input = f.apply(temp[1]);

                if(input<=y){
                    queue.add(new int[] {temp[0]+1, input});
                }
            }

        }

        return -1;
    }
}
