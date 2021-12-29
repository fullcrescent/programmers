package programmers.level2;

public class 조이스틱 {

	public static void main(String[] args) {
		String name = "JEROEN";
		int answer = solution(name);
		System.out.println(answer);
	}

	public static int solution(String name) {
		int answer = 0;
		int temp;
		for(int i=0; i<name.length(); i++) {
			temp = Integer.valueOf(name.charAt(i)) - 'A';
			if(temp > 12) {
				temp = 26 - temp;
			}
			answer += temp;
		}
		
		boolean[] visit = new boolean[name.length()];
		visit[0] = true;
		
		int i = 0;
		int plus = 0;
		int minus = 0;
		int temp1 = 0;
		int temp2 = 0;
		
		while(true) {
			if(plus>name.length()/2) break;
			plus++;
			minus++;
			
			temp1 = i + plus < name.length() ? i + plus : i+plus - name.length();
			temp2 = i - minus >= 0 ? i-minus : name.length() + (i-minus);
			
			if(name.charAt(temp1) != 'A' && !visit[temp1]) {
				visit[temp1] = true;
				i=temp1;
				answer += plus;
				plus = 0;
				minus = 0;
				continue;
			}
			
			if(name.charAt(temp2) != 'A' && !visit[temp2]) {
				visit[temp2] = true;
				i=temp2;
				answer += minus;
				plus = 0;
				minus = 0;
				continue;
			}
		}
		
		return answer;
	}
}
