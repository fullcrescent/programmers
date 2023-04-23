package programmers.level2;

public class 두_원_사이의_정수_쌍 {
    public static void main(String[] args){
        int r1 = 2;
        int r2 = 3;
        long answer = solution(r1, r2);
        System.out.println(answer);
    }

    public static long solution(int r1, int r2) {
        long count = 0;

        long in = (long) Math.pow(r1, 2);
        long out = (long) Math.pow(r2, 2);

        for(int i=0; i<r2; i++){
            for(int j=r2; j>0; j--){
                long point = (long) Math.pow(i, 2) + (long) Math.pow(j, 2);

                if(out < point){
                    continue;
                }else if(in <= point){
                    count++;
                }else {
                    break;
                }
            }
        }

        return count*4;
    }
}
