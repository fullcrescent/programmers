package programmers.level2;

public class 프렌즈4블록 {

	public static void main(String[] args) {
		int m = 4;
		int n = 5; 
		String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		int answer = solution(m, n, board);
		System.out.println(answer);
	}
	
	public static int solution(int m, int n, String[] board) {
        int answer = 0;
        
        boolean[][] delete = new boolean[m][n]; 
        
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		verification(board, i, j, delete);
        	}
        }
        return answer;
    }
	
	static int[] dx = {0, 1, 1};
	static int[] dy = {1, 0, 1};
	
	private static void verification(String[] board, int i, int j, boolean[][] delete) {
		char tile = board[i].charAt(j);
		
		int count = 1;
		
		for(int index=0; index<dx.length; index++) {
			int x = i+dx[index];
			int y = j+dy[index];
			if(x<board.length && y<board[i].length() && tile == board[x].charAt(y)) {
				count++;
			}
		}
		
		if(count==4) {
			delete[i][j] = true;
			for(int index=0; index<dx.length; index++) {
				delete[i+dx[index]][j+dy[index]] = true;
			}
		}
	}
}
