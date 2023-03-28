package programmers.level2;

import java.util.PriorityQueue;
import java.util.Queue;

public class 디펜스_게임 {
    public static void main(String[] args){
        int n = 7;
        int k = 3;
        int[] enemy = {4, 2, 4, 5, 3, 3, 1};
        int answer = solution(n, k, enemy);
        System.out.println(answer);
    }

    private static int solution(int n, int k, int[] enemy) {
        Queue<Integer> queue = new PriorityQueue<>((i1, i2) -> -Integer.compare(i1, i2));
        int sum = 0;

        for(int i=0; i<enemy.length; i++){
            sum += enemy[i];
            queue.add(enemy[i]);

            while(k>0 && n<sum && !queue.isEmpty()){
                k--;
                sum-=queue.poll();
            }

            if(n<sum){
                return i;
            }
        }

        return enemy.length;
    }
}
