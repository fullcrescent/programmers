package programmers.level2;

public class 가장_큰_정사각형_찾기 {

	public static void main(String[] args) {
		int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
		int answer = solution(board);
		System.out.println(answer);
	}

	public static int solution(int[][] board) {
		int answer = 0;
		
		int iLength = board.length;
		int jLength = board[0].length;
		
		for(int i1=0; i1<iLength; i1++) {
			for(int j1=0; j1<jLength; j1++) {
				if(board[i1][j1]==1) {
					int iIndex = i1;
					int jIndex = j1;
					
					Loop1 :
					while(true) {
						iIndex++;
						jIndex++;
						
						if(iIndex==iLength || jIndex==jLength) break;
						
						for(int i2=i1; i2<iIndex; i2++) {
							if(board[i2][jIndex]!=1) {
								break Loop1;
							}
						}
						
						for(int j2=j1; j2<jIndex; j2++) {
							if(board[iIndex][j2]!=1) {
								break Loop1;
							}
						}

						if(board[iIndex][jIndex]!=1) {
							break Loop1;
						}
					}
					answer = Math.max(answer, (int)(Math.pow(iIndex-i1, 2)));
				}
			}
		}

		return answer;
	}
}
