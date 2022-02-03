package programmers.level2;

public class 가장_큰_정사각형_찾기 {

	public static void main(String[] args) {
		int[][] board = {{1,1,1,1,1,1,1,1},{1,1,0,1,0,1,1,1},{0,0,0,1,1,1,1,1}};
		int answer = solution(board);
		System.out.println(answer);
	}

	public static int solution(int[][] board) {
		int iLength = board.length;
		int jLength = board[0].length;
		
		int count = 0;
		int temp =1;
		
		for(int i1=0; i1<iLength; i1=i1+temp) {
			temp=1;
			Loop1 :
			for(int j1=0; j1<jLength; j1++) {
				if(board[i1][j1]==1) {
					int iIndex = i1+count+1;
					int jIndex = j1+count+1;
					
					for(int i2=i1; i2<iIndex; i2++) {
						for(int j2=j1; j2<jIndex; j2++) {
							if(board[i2][j2]==0) {
								if(iIndex-i2==jIndex-j2) {
									j1=jIndex+1;
									temp=count;
								}else if(iIndex-i2<jIndex-j2){
									j1=j2;
									temp=Math.min(temp, i2-i1+1);
								}else if(iIndex-i2>jIndex-j2){
                                	i1=i2;
                                	j1=j2;
                                }
								continue Loop1;
							}
						}
					}
					
					Loop2 :
					while(true) {
						if(board.length==iIndex || board[0].length==jIndex) break;
						
						for(int i2=i1; i2<iIndex; i2++) {
							if(board[i2][jIndex]==0) {
								break Loop2;
							}
						}
						
						for(int j2=j1; j2<jIndex; j2++) {
							if(board[iIndex][j2]==0) {
								break Loop2;
							}
						}

						if(board[iIndex][jIndex]==0) {
							break Loop2;
						}

						iIndex++;
						jIndex++;
					}
					count = iIndex-i1;
					iLength = board.length-count; 
					jLength = board[0].length-count;
					j1=jIndex;
				}
			}
		}
		
		int answer = (int) Math.pow(count, 2);
		
		return answer;
	}
}
