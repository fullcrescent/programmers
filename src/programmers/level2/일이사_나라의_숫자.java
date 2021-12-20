package programmers.level2;


public class 일이사_나라의_숫자 {
	public static void main(String args[]) {
		int n1 = 1;
		int n2 = 2;
		int n3 = 3;
		int n4 = 4;
		String answer1 = solution(n1);
		String answer2 = solution(n2);
		String answer3 = solution(n3);
		String answer4 = solution(n4);
		System.out.println(answer1);
		System.out.println(answer2);
		System.out.println(answer3);
		System.out.println(answer4);
		
	}
	
	public static String solution1(int n) {
		String[] num = {"4", "1", "2"};
        StringBuilder answer = new StringBuilder();

        while(n>0){
            answer = answer.insert(0, num[n%3]);
            n = (n-1)/3;
        }

        return answer.toString().replace("0","4");
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
}
