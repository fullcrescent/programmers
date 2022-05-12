package programmers.level3;

public class 가장_긴_팰린드롬 {

	public static void main(String[] args) {
		String s = "abaabaaaaaaa";
		int answer = solution(s);
		System.out.println(answer);
		
		String s1 = "abaabaaaaaaa";
		int answer1 = solution1(s1);
		System.out.println(answer1);
	}

	public static int solution(String s) {
		StringBuffer sb = new StringBuffer();
		StringBuffer reverse_sb = new StringBuffer();
		
		sb.append(s);
		reverse_sb.append(s);
		reverse_sb.reverse();
		
		boolean flag = false;
		int max = 1;
		
		for(int i=s.length()/2; i>0; i--) {
			if(flag) break;
			for(int j=0; 2*i+j<=s.length(); j++) {
				if(2*i+j+1>s.length()) {
					if(reverse_sb.substring(s.length()-(2*i+j), s.length()-(j+i)).equals(sb.substring(j,(j+i)))) {
						max = Math.max(max, 2*i);
						flag = true;
					}
					break;
				}

				if(reverse_sb.substring(s.length()-(2*i+j+1), s.length()-(j+i)).contains(sb.substring(j, (j+i)))) {
					if(reverse_sb.substring(s.length()-(2*i+j+1), s.length()-(j+i)-1).equals(sb.substring(j, (j+i)))) {
						max = Math.max(max, 2*i+1);
						flag = true;
					}
					
					if(reverse_sb.substring(s.length()-(2*i+j), s.length()-(j+i)).equals(sb.substring(j,(j+i)))) {
						max = Math.max(max, 2*i);
						flag = true;
					}
				}
			}
		}
		
		return max;
	}

	// 다른 사람의 풀이 참고
	public static int solution1(String s) {
		int left = 0;
		int right = 0;
		
		int answer = 1;
		
		if(s.length()!=1) {
			for(int center=0; center<=s.length()-2; center++) {
				left = center;
				right = center+1;
				
				while(left>=0&&right<=s.length()-1) {
					if(s.charAt(left)!=s.charAt(right)) break;
					
					answer = Math.max(right-left+1, answer);
					left--;
					right++;
				}
			}
			
			for(int center=1; center<s.length(); center++) {
				left = center-1;
				right = center+1;
				
				while(left>=0&&right<=s.length()-1) {
					if(s.charAt(left)!=s.charAt(right)) break;
					
					answer = Math.max(right-left+1, answer);
					left--;
					right++;
				}
			}
		}
		
		return answer;
	}
}
