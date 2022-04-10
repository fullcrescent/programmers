package programmers.level3;

public class 등굣길 {

	public static void main(String[] args) {
		int m = 4;
		int n = 3;
		int[][] puddles = {{2, 2}};
		int answer = solution(m, n, puddles);
		System.out.println(answer);
	}
	
	public static int solution(int m, int n, int[][] puddles) {
		return dfs(0, 0, m-1, n-1, puddles);
	}

	private static int dfs(int x, int y, int endX, int endY, int[][] puddles) {
		if(x==endX && y==endY) {
			return 1;
		}else if(x>endX || y>endY) {
			return 0;
		}
		
		for(int i=0; i<puddles.length; i++) {
			if(x==puddles[i][0] && y==puddles[i][1]) {
				return 0;
			}
		}
		
		return dfs(x+1, y, endX, endY, puddles) + dfs(x, y+1, endX, endY, puddles); 
	}
}
