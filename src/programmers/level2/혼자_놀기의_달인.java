package programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class 혼자_놀기의_달인 {
    public static void main(String[] args) {
        int[] cards = {8,6,3,7,2,5,1,4};
        int answer = solution(cards);
        System.out.println(answer);
    }

    public static int solution(int[] cards) {
        List<Integer> list = new ArrayList<>();
        boolean[] visit = new boolean[cards.length+1];

        for(int i=1; i<visit.length; i++){
            if(visit[i])    continue;
            visit[i] = true;

            int count = 1;
            int move = cards[i-1];

            while(!visit[move]){
                count++;
                visit[move] = true;
                move = cards[move-1];
            }

            list.add(count);
        }

        list.sort((i1, i2) -> -Integer.compare(i1, i2));

        return list.size()>1 ? list.get(0)*list.get(1) : 0;
    }
}
