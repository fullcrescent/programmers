package programmers.level2;

public class n진수_게임 {

	public static void main(String[] args) {
		int n = 16;
		int t = 16;
		int m = 2;
		int p = 2;
		String answer = solution(n, t, m, p);
		System.out.println(answer);
	}
	
	public static String solution(int n, int t, int m, int p) {
		char[] array = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		
		int index = 0;
		int temp;
		
		StringBuilder sb = new StringBuilder();
		StringBuilder sbTemp = new StringBuilder();
		StringBuilder answer = new StringBuilder();
		
		while(sb.length()<=t*m) {
			temp = index;
			
			sb.append(array[temp%n]);
			
			while(temp>=n) {
				temp=temp/n;
				sbTemp.append(array[temp%n]);
			}
			
			if(sbTemp.length()!=0) {
				sb.insert(sb.length()-1, sbTemp.reverse().toString());
				sbTemp.delete(0, sbTemp.length());
			}
			
			index++;
		}
		
		String s = sb.toString();
		
		for(int i=0; i<t; i++) {
			answer.append(s.charAt(i*m+p-1));
		}
		
		return answer.toString();
	}
	
}
