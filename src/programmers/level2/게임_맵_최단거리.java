package programmers.level2;

public class 게임_맵_최단거리 {

	public static void main(String[] args) {
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		int answer = solution(maps);
		System.out.println(answer);
	}

	public static int solution(int[][] maps) {
		findLoad(maps, 0, 0, 0, new boolean[maps.length][maps[0].length]);
		return min;
	}
	
	private static int min = -1;
	
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	
	private static void findLoad(int[][] maps, int x, int y, int count, boolean[][] visit) {
		count++;
		if(x==maps.length-1 && y==maps[0].length-1) {
			if(min == -1) min = count;
			
			min = Math.min(min, count);
			
			return;
		}
		boolean[][] temp = visit;
		for(int i=0; i<dx.length; i++) {
			if((x+dx[i] < 0 || x+dx[i] == maps.length) || (y+dy[i] < 0 || y+dy[i] == maps[0].length) || visit[x+dx[i]][y+dy[i]]) continue;
			if(maps[x+dx[i]][y+dy[i]] == 1) {
				visit[x+dx[i]][y+dy[i]] = true;
				findLoad(maps, x+dx[i], y+dy[i], count, temp);
				visit[x+dx[i]][y+dy[i]] = false;
			}
		}
	}
}
