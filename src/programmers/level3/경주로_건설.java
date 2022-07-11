package programmers.level3;

public class 경주로_건설 {

	public static void main(String[] args) {
		int[][] board = {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
		int answer = solution(board);
		System.out.println(answer);
	}
	
	public static int solution(int[][] board) {
		// 꺽는거 표현 필요
		sum = new int[board.length][board[0].length];
		findLoad(board, 0, 0, 0);
		return min;
	}
	
	static int min = -1;
	static int[][] sum;
	
	private static void findLoad(int[][] maps, int x, int y, int count) {
		count++;
		if(count == min) return ;
		if(x==maps.length-1 && y==maps[0].length-1) {
			if(min == -1) min = count;
			min = Math.min(min,count);
			return;
		}
		
		if(x+1 != maps.length && maps[x+1][y] == 1) {
			if(sum[x+1][y]==0 || sum[x+1][y] > count) {
				sum[x+1][y] = count;
				findLoad(maps, x+1, y, count);
			}
		}
		
		if(y+1 != maps[0].length && maps[x][y+1] == 1) {
			if(sum[x][y+1]==0 || sum[x][y+1] > count) {
				sum[x][y+1] = count;
				findLoad(maps, x, y+1, count);
			}
		}
		
		if(x-1 > -1 && maps[x-1][y] == 1) {
			if(sum[x-1][y]==0 || sum[x-1][y] > count) {
				sum[x-1][y] = count;
				findLoad(maps, x-1, y, count);
			}
		}
		
		if(y-1 > -1 && maps[x][y-1] == 1) {
			if(sum[x][y-1]==0 || sum[x][y-1] > count) {
				sum[x][y-1] = count;
				findLoad(maps, x, y-1, count);
			}
		}
	}
}
