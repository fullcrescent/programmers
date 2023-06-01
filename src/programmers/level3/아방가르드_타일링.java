package programmers.level3;

public class 아방가르드_타일링 {
    public static void main(String[] args){
        int n = 3;
        int answer = solution(n);
        System.out.println(answer);
    }

    public static int solution(int n) {
        // 1 > 1 : 1
        // 2 > 1+1 > 1 / 2 > 2 : 3
        // 3 > 1+1+1 > 1 /  1+2 > 2 /  2+1 > 2 / 3 > 5 : 10
        // 4 > 1+1+1+1 > 1 / 1+1+2 > 2 / 1+2+1 > 2 / 2+1+1 > 2 / 2+2 > 4 / 3+1 > 5 / 1+3 > 5 : 21




        return 0;
    }
}
