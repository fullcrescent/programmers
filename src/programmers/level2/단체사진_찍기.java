package programmers.level2;

public class 단체사진_찍기 {

	public static void main(String[] args) {
		int n = 2;
		String[] data = {"N~F=0", "R~T>2"};
		int answer = solution(n, data);
		System.out.println(answer);
		
		int n1 = 2;
		String[] data1 = {"N~F=0", "R~T>2"};
		int answer1 = solution1(n1, data1);
		System.out.println(answer1);
	}
	
	public static int solution(int n, String[] data) {
		answer = 0;
		boolean[] visit = new boolean[8];
		
		dfs(visit, data, new StringBuilder(), 0);
		
		return answer;
	}

	static char[] member = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
	static int answer;
	
	private static void dfs(boolean[] visit, String[] data, StringBuilder sb, int count) {
		if(!validation(data, sb.toString())) {
			return;
		}else if(count==8) {
			answer++;
			return;
		}
		
		for(int i=0; i<visit.length;i++) {
			if(visit[i]) continue;
			
			visit[i] = true;
			dfs(visit, data, sb.append(member[i]), count+1);
			sb.deleteCharAt(sb.length()-1);
			visit[i] = false;
		}
	}

	private static boolean validation(String[] data, String s) {
		for(String temp : data) {
			int temp1 = s.indexOf(temp.charAt(0));
			int temp2 = s.indexOf(temp.charAt(2));
			
			if(temp1==-1||temp2==-1) {
				continue;
			}
			
			char sign = temp.charAt(3);
			
			if(sign=='>') {
				if(!(Math.abs(temp1-temp2)-1>Integer.valueOf(temp.substring(4)))) {
					return false;
				}
			}else if(sign=='<') {
				if(!(Math.abs(temp1-temp2)-1<Integer.valueOf(temp.substring(4)))) {
					return false;
				}
			}else {
				if(!(Math.abs(temp1-temp2)-1==Integer.valueOf(temp.substring(4)))) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	// 다른 사람의 풀이 참고 - 변경X
	public static int solution1(int n, String[] data) {
		answer = 0;
		boolean[] visit = new boolean[8];
		
		dfs(visit, data, new StringBuilder(), 0);
		
		return answer;
	}
}
