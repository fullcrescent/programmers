package programmers.level3;

import java.util.ArrayList;
import java.util.List;

public class 코딩_테스트_공부 {

	public static void main(String[] args) {
		int alp = 0;
		int cop = 0;
		int[][] problems = {{4,11,4,0,2},{4,5,3,1,2},{0,0,2,1,2},{10,4,0,4,2}};
		int answer = solution(alp, cop, problems);
		System.out.println(answer);
	}
	
	public static int solution(int alp, int cop, int[][] problems) {
		int answer = 0;
		
		List<int[]> list = new ArrayList<>();
		
		for(int[] temp : problems) {
			list.add(temp);
		}
		
		list.sort((i1, i2) -> {
			if(i1[0]==i2[0]) {
				return Integer.compare(i1[1], i2[1]);
			}
			return Integer.compare(i1[0], i2[0]);
		});
		
		int index = 0;
		
		while(index<list.size()) {
			for(int i=index; i<list.size(); i++) {
				int[] temp = list.get(i);
				
				if(alp>=temp[0] && cop>=temp[1]) {
					index++;
					alp += temp[2];
					cop += temp[3];
					answer += temp[4];
				}
			}
			index--;
		}
		
		return answer;
	}
}
