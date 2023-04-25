package programmers.level2;

public class 두_원_사이의_정수_쌍 {
    public static void main(String[] args){
        int r1 = 2;
        int r2 = 3;
        long answer = solution(r1, r2);
        System.out.println(answer);

        int r1_1 = 2;
        int r2_1 = 3;
        long answer_1 = solution1(r1_1, r2_1);
        System.out.println(answer_1);
    }

    public static long solution(int r1, int r2) {
        long count = 0;

        for(int i=0; i<r2; i++){
            long out = (long) Math.floor(Math.sqrt(Math.pow(r2, 2) - Math.pow(i, 2)));
            long in = (long) Math.ceil(Math.sqrt(Math.pow(r1, 2) - Math.pow(i, 2)));

            count += out - (in==0 ? 0 : in - 1);
        }

        return count*4;
    }

    /*다른 사람의 풀이 참고*/
    public static long solution1(int r1, int r2) {
        long count = 0;

        for(int i=1; i<=r2; i++){
            long out = (long) Math.floor(Math.sqrt(Math.pow(r2, 2) - Math.pow(i, 2)));
            long in = (long) Math.ceil(Math.sqrt(Math.pow(r1, 2) - Math.pow(i, 2)));

            count += out - in +1;
        }

        return count*4;
    }
}
