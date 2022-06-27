package programmers.level3;

public class 리틀_프렌즈_사천성 {

	public static void main(String[] args) {
		int m = 3;
		int n = 4; 
		String[] board = {".A*.", "AN..", "*N**"};
		String answer = solution(m, n, board);
		System.out.println(answer);
	}
	
	public static String solution(int m, int n, String[] board) {
		String answer = "";
		String tempAnswer = null;
		
		while(answer!=tempAnswer) {
			tempAnswer = answer;
			
			char temp = 64;
			
			while(temp++<91) {
				int startX = -1, startY = -1, endX = -1, endY = -1;
				
				Loop :
				for(int i=0; i<m; i++) {
					for(int j=0; j<n; j++) {
						if(board[i].charAt(j)==temp) {
							if(startX==-1) {
								startX = i;
								startY = j;
							}else if(endX==-1){
								endX = i;
								endY = j;
								break Loop;
							}
						}
					}
				}
				
				if(endX==-1) continue;
				
				int i = startX<endX ? 1 : -1;
				int j = startY<endY ? 1 : -1;
				
				if(startX!=endX) {
					int tempX = startX;
					int tempY = startY;
					
					boolean flag = true;
					
					while(tempX!=endX) {
						tempX += i;
						
						if(board[tempX].charAt(startY)!='.') {
							flag = false;
							break;
						}
					}
					
					if(flag) {
						while(tempY!=endY) {
							tempY += j;
							
							if(board[tempX].charAt(tempY)!='.') {
								break;
							}
						}
					}
					
					if(tempX==endX && tempY==endY) {
						answer += temp;
						board[startX] = board[startX].replace(temp, '.');
						board[endX] = board[endX].replace(temp, '.');	
						continue;
					}
				}
				
				if(startY!=endY) {
					int tempX = startX;
					int tempY = startY;
					
					boolean flag = true;
					
					while(tempY!=endY) {
						tempY += j;
						
						if(board[startX].charAt(tempY)!='.') {
							flag = false;
							break;
						}
					}
					
					if(flag) {
						while(tempX!=endX) {
							tempX += i;
							
							if(board[tempX].charAt(tempY)!='.') {
								break;
							}
						}
					}
					
					if(tempX==endX && tempY==endY) {
						answer += temp;
						board[startX] = board[startX].replace(temp, '.');
						board[endX] = board[endX].replace(temp, '.');
						continue;
					}
				}
			}
		}
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(board[i].charAt(j)>64 && board[i].charAt(j)<91){
					return "IMPOSSIBLE";
				}
			}
		}
		
		return answer;
	}
}
