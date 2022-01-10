package programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
		System.out.println(answer);
	}

	public static int solution(String[][] relation) {
		boolean visit[] = new boolean[relation[0].length];
		
		for(int i=0; i<visit.length; i++) {
			combination(relation, visit, 0, i+1);
		}

		return candidateVisit.size();
	}
	
	private static List<boolean[]> candidateVisit = new LinkedList<>();
	
	private static void combination(String[][] relation, boolean[] visit, int index, int count) {
		if(count==0) {
			for(boolean[] tempVisit : candidateVisit) {
				int tempIndex = 0;
				
				int tempCount = 0;
				int visitCount = 0;
				
				for(boolean temp : tempVisit) {
					if(temp) {
						tempCount++;
						if(visit[tempIndex]) {
							visitCount++;
						}
					}
					tempIndex++;
				}
				
				if(tempCount==visitCount) {
					return;
				}
			}
			
			Map<String, String> map = new HashMap<>();
			
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
				if(map.containsKey(key) || map.containsValue(value)) {
					return;
				}
				map.put(key, value);
			}
			
			boolean[] temp = Arrays.copyOf(visit, visit.length);
			
			candidateVisit.add(temp);
			
			return;
		}
		
		for(int i=index; i<visit.length; i++) {
			visit[i] = true;
			combination(relation, visit, i+1, count-1);
			visit[i] = false;	
		}
	}

}
