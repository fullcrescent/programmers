package programmers.level3;

public class 거스름돈 {
    public static void main(String[] args) {
        int n = 5;
        int[] money = {1,2,5};
        int answer = solution(n, money);
        System.out.println(answer);
    }

    public static int solution(int n, int[] money) {
        return function(n, money, 0);
    }

    private static int function(int n, int[] money, int index) {
        if(n==0){
            return 1;
        }else if(n<0){
            return 0;
        }

        int answer = 0;

        for(int i=index; i<money.length; i++){
            answer += function(n-money[index], money, index);
            index++;
        }

        return answer;
    }
}