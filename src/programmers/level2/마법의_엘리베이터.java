package programmers.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class 마법의_엘리베이터 {
    public static void main(String[] args){
        int storey = 2554;
        int answer = solution(storey);
        System.out.println(answer);
    }

    public static int solution(int storey) {
        int[] array = Stream.of(String.valueOf(storey).split("")).mapToInt(Integer::parseInt).toArray();

        for(int i : array){
            System.out.println(i);
        }


        return 0;
    }
}
