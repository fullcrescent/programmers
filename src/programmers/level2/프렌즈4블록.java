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
        
        char[][] charBoard = new char[m][n];
        boolean[][] delete = new boolean[m][n]; 
        
        int x = 0;
        for(String temp : board) {
       		charBoard[x++] = temp.toCharArray();
        }
        while(true) {
        	for(int i=0; i<m; i++) {
        		for(int j=0; j<n; j++) {
        			verification(charBoard, i, j, delete);
        		}
        	}
        	
        	int count = 0;
        	for(boolean[] temp1 : delete) {
        		for(boolean temp2 : temp1) {
        			if(temp2) count ++; 
        		}
        	}
        	
        	answer += count;
        	
        	if(count==0) {
        		break;
        	}
        	
        	for(int i=0; i<m; i++) {
        		for(int j=0; j<n; j++) {
        			if(i==0) {
        				delete[i][j] = false;
        			}else if(delete[i][j]) {
        				int temp1 = i;
        				int temp2 = j;
        				while(temp1>0) {
        					charBoard[temp1][temp2] = charBoard[--temp1][temp2];
        				}
        				charBoard[temp1][temp2] = 0;
        				delete[i][j] = false;
        			}
        		}
        	}
        }
        
        return answer;
    }
	
	static int[] dx = {0, 1, 1};
	static int[] dy = {1, 0, 1};
	
	private static void verification(char[][] charBoard, int i, int j, boolean[][] delete) {
		char tile = charBoard[i][j];
		
		if(tile==0) {
			return;
		}
		
		int count = 1;
		
		for(int index=0; index<dx.length; index++) {
			int x = i+dx[index];
			int y = j+dy[index];
			if(x<charBoard.length && y<charBoard[i].length && tile == charBoard[x][y]) {
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
