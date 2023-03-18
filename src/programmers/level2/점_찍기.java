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
            for(int j=0; j<=d; j=j+k){
                if((i*i)+(j*j)<=d*d){
                    answer++;
                }
            }
        }

        return answer;
    }
}
