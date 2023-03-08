package programmers.level2;

public class 유사_칸토어_비트열 {
    public static void main(String[] args){
        int n = 2;
        long l = 15;
        long r = 25;
        int answer = solution(n, l, r);
        System.out.println(answer);
    }

    public static int solution(int n, long l, long r) {
        int answer = 0;
        long all = (long) Math.pow(5, n);

        for(var i=l; i<=r; i++){
            long divide = all;
            long temp = i;

            while(true){
                divide /= 5;

                if(divide*2<temp && temp<divide*3+1){
                    i = divide * ((i-1)/divide+1);
                    break;
                }

                if(divide==1) {
                    answer++;
                    break;
                }

                temp = temp%divide;
            }
        }

        return answer;
    }
}
