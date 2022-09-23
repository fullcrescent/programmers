package programmers.level3;

import java.util.PriorityQueue;
import java.util.Queue;

public class 경주로_건설 {

	public static void main(String[] args) {
		int[][] board = {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
		int answer = solution(board);
		System.out.println(answer);
		
		int[][] board1 = {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
		int answer1 = solution1(board1);
		System.out.println(answer1);
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
	
	// 다른 사람의 풀이 참고
	public static int solution1(int[][] board) {
		int answer = Integer.MAX_VALUE;
		// dfs의 경우 방향성 고려 X, bfs의 경우 방향성에 따른 고려 O
		int[][][] sum1 = new int[board.length][board[0].length][4];
		sum1[0][0][0] = -1;
		sum1[0][0][1] = -1;
		sum1[0][0][2] = -1;
		sum1[0][0][3] = -1;
		
		int[] dx1 = {1, 0, -1, 0};   
		int[] dy1 = {0, 1, 0, -1};   
		int[] dir1 = {0, 1, 2, 3};
		int curveCost = 600;   
		int straightCost = 100;
		
		Queue<Point> queue = new PriorityQueue<>((i1, i2) -> Integer.compare(i1.cost, i2.cost));
		
		queue.add(new Point(0, 0, -1, -500));
		
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			
			if(point.x==board.length-1 && point.y==board[0].length-1) {
				answer = Math.min(point.cost, answer);
				break;
			}
			
			for(int i=0; i<4; i++) {
				int tempX = point.x+dx1[i];
				int tempY = point.y+dy1[i];
				
				if(tempX<=board.length-1 && tempX>-1 && tempY<=board[tempX].length-1 && tempY>-1 && board[tempX][tempY] == 0) {
					int tempCost = point.cost + (point.dir!=dir1[i] ? curveCost : straightCost);
					if(sum1[tempX][tempY][dir1[i]]==0 || sum1[tempX][tempY][dir1[i]] >= tempCost) {						
						sum1[tempX][tempY][dir1[i]] = tempCost;
						queue.add(new Point(tempX, tempY, dir1[i], tempCost));
					}
				}
			}
		}
		
		return answer;
	}
}

class Point{
	int x;
	int y;
	int dir;
	int cost;
	
	public Point(int x, int y, int dir, int cost) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.cost = cost;
	}
}
