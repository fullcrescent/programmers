package programmers.level2;

import java.util.Arrays;

public class 후보키 {

	public static void main(String[] args) {
		String[][] relation = {
				{"100","ryan","music","2"}
				,{"200","apeach","math","2"}
				,{"300","tube","computer","3"}
				,{"400","con","computer","4"}
				,{"500","muzi","music","3"}
				,{"600","apeach","music","2"}};
		int answer = solution(relation);
//		System.out.println(answer);
	}

	public static int solution(String[][] relation) {
		boolean visit[] = new boolean[relation[0].length];
		
		for(int i=0; i<visit.length; i++) {
			
		}
		
		combination(relation, visit, 0, 1);
		return 0;
	}
	
	private static int answer = 0;
	
	private static void combination(String[][] relation, boolean[] visit, int index, int count) {
		if(count==0) {
			for(int i=0; i<relation.length; i++) {
				String key="";
				String value="";
				
				for(int j=0; j<relation[i].length; j++) {
					if(visit[j]) {
						key += relation[i][j];
					}else {
						value += relation[i][j];
					}
				}
				System.out.println("key=" + key);
				System.out.println("value=" + value);
			}
			
			
			return;
		}
		
		for(int i=index; i<visit.length; i++) {
			visit[i] = true;
			combination(relation, visit, i+1, count-1);
			visit[i] = false;	
		}
		
	}

}
