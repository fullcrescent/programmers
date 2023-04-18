package programmers.level2;

import java.util.stream.Stream;

public class 마법의_엘리베이터 {
    public static void main(String[] args){
        int storey = 2554;
        int answer = solution(storey);
        System.out.println(answer);
    }

    public static int solution(int storey) {
        int answer = 0;

        int[] array = Stream.of(("0"+storey).split("")).mapToInt(Integer::parseInt).toArray();

        for(int i=array.length-1; i>-1; i--){
            if(array[i]>4){
                answer += 10-array[i];
                array[i-1] += 1;
            }else{
                answer += array[i];
            }
        }

        return answer;
    }
}
