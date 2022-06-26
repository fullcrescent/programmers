package programmers.level3;

public class 리틀_프렌즈_사천성 {

	public static void main(String[] args) {
		int m = 2;
		int n = 4; 
		String[] board = {"NRYN", "ARYA"};
		String answer = solution(m, n, board);
		System.out.println(answer);
	}
	
	public static String solution(int m, int n, String[] board) {
		String answer = "";
		
		char temp = 64;

		while(temp++<91) {
			Point p1 = null;
			Point p2 = null;
			
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					if(board[i].charAt(j)==temp) {
						if(p1==null) {
							p1 = new Point(i, j);
						}else {
							p2 = new Point(i, j);
						}
					}
				}
			}
			
			int startX, endX, startY, endY;
			
			if(p1==null) {
				continue;
			}
			
			if(p1.x<p2.x) {
				startX = p1.x;
				endX = p2.x;
			}else {
				startX = p2.x;
				endX = p1.x;
			}
					 
			if(p1.y<p2.y) {
				startY = p1.y;
				endY = p2.y;
			}else {
				startY = p2.y;
				endY = p1.y;
			}
			
			Loop1 :
			for(int i=startX+1; i<=endX; i++) {
				for(int j=startY; j<=endY; j++) {
					if(board[i].charAt(j)==temp) {
						answer += temp;
						board[p1.x] = board[p1.x].replace(temp, '*');
						board[p2.x] = board[p2.x].replace(temp, '*');		
					}else if(board[i].charAt(j)=='.') {
						break Loop1;
					}
				}
			}
			
			Loop2 :
			for(int i=startY+1; i<=endY; i++) {
				for(int j=startX; j<=endX; j++) {
					if(board[i].charAt(j)==temp) {
						answer += temp;
						board[p1.x] = board[p1.x].replace(temp, '*');
						board[p2.x] = board[p2.x].replace(temp, '*');		
					}else if(board[i].charAt(j)=='.') {
						break Loop2;
					}
				}
			}
		}

		return answer;
	}
	
	static class Point{
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
