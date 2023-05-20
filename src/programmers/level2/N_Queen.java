package programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class N_Queen {
    public static void main(String[] args) {
        int n = 4;
        int answer = solution(n);
        System.out.println(answer);
    }

    public static int solution(int n) {
        for(int i=0; i<n; i++){
            boolean[] visit = new boolean[n];
            visit[i] = true;

            List<Integer> list = new ArrayList<>();
            list.add(i);

            for(int j=1; j<n; j++){
                for(int k=0; k<n; k++){
                    if(visit[k]) continue;


                }
            }

        }


        return 0;
    }
}
