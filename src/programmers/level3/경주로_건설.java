package programmers.level3;

public class 경주로_건설 {

	public static void main(String[] args) {
		int[][] board = {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
		int answer = solution(board);
		System.out.println(answer);
	}
	
	public static int solution(int[][] board) {
		sum = new int[board.length][board[0].length];
		sum[0][0] = -1;
		
		findLoad(board, 0, 0, -500, -1);
		
		return min;
	}
	
	static int min = 1<<30;
	static int[][] sum;
	
	static int curveCost = 600;
	static int straightCost = 100;
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int[] direct = {0, 1, 2, 3};
	
	private static void findLoad(int[][] maps, int x, int y, int count, int direction) {
		if(count >= min) return ;
		
		if(x==maps.length-1 && y==maps[0].length-1) {
			min = Math.min(min,count);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int tempX = x+dx[i];
			int tempY = y+dy[i];
			
			if(tempX<=maps.length-1 && tempX>-1 && tempY<=maps[tempX].length-1 && tempY>-1 && maps[tempX][tempY] == 0) {
				if(sum[tempX][tempY]==0 || sum[tempX][tempY] >= count) {						
					int tempCount = count + (direction!=direct[i] ? curveCost : straightCost);
					sum[tempX][tempY] = tempCount;
					findLoad(maps, tempX, tempY, tempCount, direct[i]);
				}
			}
		}
	}
}
