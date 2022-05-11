package programmers.level3;

public class 가장_긴_팰린드롬 {

	public static void main(String[] args) {
		String s = "abaabaaaaaaa";
		int answer = solution(s);
		System.out.println(answer);
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

}
