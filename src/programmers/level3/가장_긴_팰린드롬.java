package programmers.level3;

public class 가장_긴_팰린드롬 {

	public static void main(String[] args) {
		String s = "abcdefedcb";
		int answer = solution(s);
		System.out.println(answer);
	}

	public static int solution(String s) {
		StringBuffer sb = new StringBuffer();
		StringBuffer reverse_sb = new StringBuffer();
		
		sb.append(s);
		reverse_sb.append(s);
		reverse_sb.reverse();
		
		for(int i=s.length()/2+1; i>1; i--) {
			for(int j=0; j+i<=s.length()/2+1; j++) {
				if(s.length()-2*(j+i)<0) {
					if(reverse_sb.substring(s.length()-2*(j+i)+1, s.length()-(j+i)+1).contains(sb.substring(j,(j+i)))) {
						return 2*i-1;
					}
					continue;
				}
				
				if(reverse_sb.substring(s.length()-2*(j+i), s.length()-(j+i)+1).contains(sb.substring(j, (j+i)))) {
					if(reverse_sb.substring(s.length()-2*(j+i)+1, s.length()-(j+i)+1).contains(sb.substring(j,(j+i)))) {
						return 2*i-1;
					}
					return 2*i;
				}
			}
		}
		
		return 0;
	}

}
