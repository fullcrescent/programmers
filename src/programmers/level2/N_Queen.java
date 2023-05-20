package programmers.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class N_Queen {
    public static void main(String[] args) {
        int n = 4;
        int answer = solution(n);
        System.out.println(answer);
    }

    public static int solution(int n) {
        Function<Integer, Boolean> f = i -> -1<i && i<n;

        for(int i=0; i<n; i++){
            boolean[] visit = new boolean[n];
            visit[i] = true;

            List<Info> list = new ArrayList<>();
            function(i, f, list);

            for(int j=1; j<n; j++){
                for(int k=0; k<n; k++){
                    //if(visit[k] || list.contains(k)) continue;

                    visit[k] = true;
                    function(k, f, list);
                }
            }

        }


        return 0;
    }

    private static void function(int i, Function<Integer, Boolean> f, List<Info> list) {
        if(f.apply(i-1)) list.add(new Info(Direction.North, i-1));
        if(f.apply(i+1)) list.add(new Info(Direction.South, i+1));
    }

    static class Info{
        Direction direction;
        int value;

        public Info(Direction direction, int value) {
            this.direction = direction;
            this.value = value;
        }
    }

    enum Direction{
        North, South
    }
}
