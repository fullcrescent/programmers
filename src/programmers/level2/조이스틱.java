package programmers.level2;

public class 조이스틱 {

	public static void main(String[] args) {
		String name = "AAAABBBBBBBAA";
		int answer = solution(name);
		System.out.println(answer);
		
		String name1 = "AAAABBBBBBBAA";
		int answer1 = solution1(name1);
		System.out.println(answer1);
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
	
	// 다른 사람의 풀이 참고
	public static int solution1(String name) {
		int answer = 0;

		for(char temp : name.toCharArray()) {
			answer += temp-'A'>12 ? 26-temp+'A' : temp-'A';
		}
		
		int min = name.length()-1;
		
		for(int i=0; i<name.length(); i++) {
			int next = i+1;
			while(next<name.length()&&name.charAt(next)=='A') {
				next++;
			}
			min = Math.min(min, i+name.length()-next+Math.min(i, name.length()-next));
		}
		
		return answer+min;
	}
}
