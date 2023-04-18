package programmers.level2;

import java.util.stream.Stream;

public class 마법의_엘리베이터 {
    public static void main(String[] args){
        int storey = 545;
        int answer = solution(storey);
        System.out.println(answer);
    }

    public static int solution(int storey) {
        int answer = 0;

        int[] array = Stream.of(("0"+storey).split("")).mapToInt(Integer::parseInt).toArray();
        boolean[] flags = new boolean[array.length];

        for(int i=array.length-1; i>-1; i--){
            int flag = flags[i] ? 1 : 0;

            if(array[i]<5-flag){
                answer += array[i]-flag;
            }else{
                answer += 10-array[i];
                array[i-1] += 1;
                flags[i-1] = true;
            }
        }

        return answer;
    }
}
