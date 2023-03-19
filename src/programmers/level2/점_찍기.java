package programmers.level2;

public class 점_찍기 {
    public static void main(String[] args){
        int k = 1;
        int d = 5;
        long answer = solution(k, d);
        System.out.println(answer);
    }

    public static long solution(int k, int d) {
        long answer = 0;

        for(int i=0; i<=d; i=i+k){
            answer += Math.sqrt((long)Math.pow(d, 2) - (long)Math.pow(i, 2))/k +1;
        }

        return answer;
    }
}
