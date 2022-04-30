package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class 후보키 {

	public static void main(String[] args) {
//		String[][] relation = {
//				{"100","ryan","music","2", "4"}
//				,{"200","apeach","math","2", "5"}
//				,{"300","tube","computer","3", "6"}
//				,{"400","con","computer","4", "7"}
//				,{"500","muzi","music","3", "8"}
//				,{"600","ryan","music","2", "4"}};
		
		// 처음 생각한 조건문 if(map.containsKey(key) || map.containsValue(value))이 유효하게 동작하지 않게하는 예시
		String[][] relation = {
				{"aaa","a2b","c"}
				,{"bbb","a","b2c"}};
		int answer = solution(relation);
		System.out.println(answer);
		
		String[][] relation1 = {
				{"aaa","a2b","c"}
				,{"bbb","a","b2c"}};
		int answer1 = solution1(relation1);
		System.out.println(answer1);
	}

	public static int solution(String[][] relation) {
		boolean visit[] = new boolean[relation[0].length];
		
		for(int i=0; i<visit.length; i++) {
			// visit.length개에서 i+1개를 뽑는 경우의 수 -> 조합
			combination(relation, visit, 0, i+1);
		}

		return candidateVisit.size();
	}
	
	// 후보키 방문 내역 리스트
	private static List<boolean[]> candidateVisit = new LinkedList<>();
	
	private static void combination(String[][] relation, boolean[] visit, int index, int count) {
		// 주어진 개수만큼 뽑았을 경우
		if(count==0) {
			// 후보키 방문 내역 리스트에서 visit를 비교하여 최소성 검사
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
			
			// 유일성 검사			
			Map<String, String> map = new HashMap<>();
			
			for(int i=0; i<relation.length; i++) {
				String key="";
				String value="";
				
				for(int j=0; j<relation[i].length; j++) {
					if(visit[j]) {
						key += j+relation[i][j];
					}else {
						value += j+relation[i][j];
					}
				}
				
				// 처음 생각한 조건문 if(map.containsKey(key) || map.containsValue(value))의 경우 배열을 조작하면 잘못된값 출력 가능
				// key 중복일 경우 종료
				if(map.containsKey(key)) {
					return;
				}
				
				// Random a = new Random();
				// value += a.nextLong()+relation[i][j];  
				// value 앞의 접두사를 Random수로 바꾼 후 throws Exception과 아래의 소스로 테스트할 경우 5,6,8,21 테스트 케이스에서 런타임 에러 확인
				// ???? 테스트 케이스가 어떻게 되는건지...
//				if(map.containsValue(value)){
//                    throw new Exception();
//                }
				
				map.put(key, value);
			}
			
			boolean[] temp = Arrays.copyOf(visit, visit.length);
			
			candidateVisit.add(temp);
			
			return;
		}
		
		// 조합
		for(int i=index; i<visit.length; i++) {
			visit[i] = true;
			combination(relation, visit, i+1, count-1);
			visit[i] = false;	
		}
	}
	
	// 다른 사람의 풀이 참고
	public static int solution1(String[][] relation) {
		List<Integer> list = new ArrayList<>();
		
		for(int i=1; i<(1<<relation[0].length); i++) {			// 조합의 합
			Set<String> set = new HashSet<>();
			
			for(int j=0; j<relation.length; j++) {
				String now = "";
				
				for(int k=0; k<relation[j].length; k++) {
					System.out.println(i);
					System.out.println((1<<k));
					System.out.println(i & (1<<k));
					if((i & (1<<k)) > 0) now += relation[j][k];
				}

				set.add(now);
			}
			if(set.size() == relation.length && possible(list, i)) list.add(i);
		}
		
		return list.size();
	}

	private static boolean possible(List<Integer> list, int now) {
		for(int i=0; i<list.size(); i++) {
			if((list.get(i)&now) == list.get(i)) return false;
		}
		
		return true;
	}
	
}
