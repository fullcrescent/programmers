package programmers.level2;

public class 유사_칸토어_비트열 {
    public static void main(String[] args){
        int n = 2;
        long l = 4;
        long r = 17;
        int answer = solution(n, l, r);
        System.out.println(answer);
    }

    public static int solution(int n, long l, long r) {
        StringBuilder sb = new StringBuilder();
        sb.append(1);

        for(int i=0; i<n; i++){
            String temp = sb.toString();
            sb.append(temp);

            for(int j=0; j<Math.pow(5, i); j++){
                sb.append(0);
            }

            sb.append(temp);
            sb.append(temp);
        }

        return (int) sb.substring((int) l-1, (int) r).chars().filter(input -> input=='1').count();
    }
}
