package programmers.level2;

import java.util.Arrays;

public class 행렬_테두리_회전하기 {

	public static void main(String[] args) {
		int rows = 6;
		int columns = 6;
		int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		int[] answer = solution(rows, columns, queries);
		System.out.println(Arrays.toString(answer));
	}
	
	public static int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		Arrays.fill(answer, rows*columns);
		
		int[][] array = new int[rows][columns];
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<columns; j++) {
				array[i][j] = i*columns + (j+1); 
			}
		}
		
		for(int i=0; i<queries.length; i++) {
			int in = 0;
			int out = 0;
			int flag = 0;
			
			int x = queries[i][0]-1;
			int y = queries[i][1]-1;
			
			while(true) {
				in = (out==0) ? array[x][y] : out;
				
				if((x>=queries[i][2]-1 || x<queries[i][0]-1) && (y==queries[i][3]-1 || y==queries[i][1]-1)) {
					flag++;
				}else if((y>=queries[i][3]-1 || y<queries[i][1]-1) && (x==queries[i][2]-1 || x==queries[i][0]-1)) {
					flag++;
				}else if(x==queries[i][0]-1 && y==queries[i][1]-1) {
					flag++;
				}
				
				if(flag==1) {
					out = array[x][++y];
				}else if(flag==2) {
					out = array[++x][y];
				}else if(flag==3) {
					out = array[x][--y];
				}else if(flag==4) {
					out = array[--x][y];
				}else {
					break;
				}
				
				array[x][y] = in;
				answer[i] = Math.min(answer[i], in);
			}
		}
		
		return answer;
	}

}
