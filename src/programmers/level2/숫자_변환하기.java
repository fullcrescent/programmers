package programmers.level2;

import java.util.*;
import java.util.function.Function;

public class 숫자_변환하기 {
    public static void main(String[] args){
        int x = 10;
        int y = 33;
        int n = 5;
        int answer = solution(x, y, n);
        System.out.println(answer);

        int x1 = 10;
        int y1 = 33;
        int n1 = 5;
        int answer1 = solution1(x1, y1, n1);
        System.out.println(answer1);
    }

    public static int solution(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, x});

        Set<Integer> set = new HashSet<>();
        set.add(x);

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
                    if(!set.contains(input)){
                        queue.add(new int[] {temp[0]+1, input});
                        set.add(input);
                    }
                }
            }

        }

        return -1;
    }

    /*다른 사람의 풀이 참고*/
    public static int solution1(int x, int y, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);

        List<Function<Integer, Integer>> list = new ArrayList<>();
        list.add(i -> i*2);
        list.add(i -> i*3);
        list.add(i -> i+n);

        int[] count = new int[1000001];

        while(!queue.isEmpty()){
            int temp = queue.poll();

            if(temp==y){
                return count[temp];
            }

            for(Function<Integer, Integer> f : list){
                int next = f.apply(temp);

                if(next<=y && count[next]==0){
                    queue.add(next);
                    count[next] = count[temp]+1;
                }
            }
        }

        return -1;
    }
}