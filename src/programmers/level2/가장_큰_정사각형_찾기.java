package programmers.level2;

public class 가장_큰_정사각형_찾기 {

	public static void main(String[] args) {
		int[][] board = {{1,1,1,1,1,1,1,1},{1,1,0,1,0,1,1,1},{0,0,0,1,1,1,1,1}};
		int answer = solution(board);
		System.out.println(answer);
		
		int[][] board1 = {{1,1,1,1,1,1,1,1},{1,1,0,1,0,1,1,1},{0,0,0,1,1,1,1,1}};
		int answer1 = solution1(board1);
		System.out.println(answer1);
	}

	public static int solution(int[][] board) {
		int[][] dp = new int[board.length][board[0].length];
		
		for(int i=0; i<board[0].length; i++) {
			dp[0][i] = board[0][i];
		}
		
		for(int i=1; i<board.length;i++) {
			for(int j=0; j<board[i].length;j++) {
				if(board[i][j]==0) {
					dp[i][j]=0;
				}else {
					if(i-1>-1 && j-1>-1) {
						int min = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
						dp[i][j] = min+1;
					}else {
						dp[i][j] = 1;
					}
				}
			}
		}
		
		int answer =0;
		
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[i].length; j++) {
				answer = Math.max(answer, dp[i][j]);
			}
		}
		
		return (int) Math.pow(answer, 2);
	}
	
	// 다른 사람의 풀이 참고
	public static int solution1(int[][] board) {
		int answer =0;
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				if(board[i][j]>0) {
					board[i][j] = Math.min(Math.min(j>0 ? board[i][j-1]:0, i>0 ? board[i-1][j] : 0), i>0&&j>0 ? board[i-1][j-1] : 0) + 1;
					answer = Math.max(answer, board[i][j]);
				}
			}
		}
		return (int) Math.pow(answer, 2);
	}
	
}
