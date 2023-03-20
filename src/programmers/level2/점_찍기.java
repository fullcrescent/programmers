package programmers.level2;

public class 점_찍기 {
    public static void main(String[] args){
        int k = 1;
        int d = 5;
        long answer = solution(k, d);
        System.out.println(answer);

        int k1 = 1;
        int d1 = 5;
        long answer1 = solution1(k1, d1);
        System.out.println(answer1);
    }

    public static long solution(int k, int d) {
        long answer = 0;

        for(int i=0; i<=d; i=i+k){
            answer += (long) (Math.sqrt((long)Math.pow(d, 2) - (long)Math.pow(i, 2))/k +1);
        }

        return answer;
    }

    /*다른 사람의 풀이 참고*/
    public static long solution1(int k, int d) {
        long answer = 0;

        for(int i=0; i<=d; i=i+k){
            answer += (int) (Math.sqrt(Math.pow(d, 2) - Math.pow(i, 2))/k +1);
        }

        return answer;
    }
}
