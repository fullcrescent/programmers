package programmers.level2;


public class 일이사_나라의_숫자 {
	public static void main(String args[]) {
		int n = 15;
		String answer = solution(n);
		System.out.println(answer);
		
		int n1 = 15;
		String answer1 = solution1(n1);
		System.out.println(answer1);
	}
	
	public static String solution(int n) {
        StringBuilder answer = new StringBuilder();

        while(n>0){
            answer.append(n%3);
            if(n%3==0) n -=1;
            n /=3;
        }

        return answer.reverse().toString().replace("0","4");
    }
	
	// 다른 사람의 풀이 참고
	public static String solution1(int n) {
		String[] num = {"4", "1", "2"};
        StringBuilder answer = new StringBuilder();

        while(n>0){
            answer = answer.insert(0, num[n%3]);
            n = (n-1)/3;
        }

        return answer.toString();
    }
}
