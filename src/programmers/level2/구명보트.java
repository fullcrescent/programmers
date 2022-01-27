package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 구명보트 {

	public static void main(String[] args) {
		int[] people = {70, 50, 80, 50};
		int limit = 100;
		int answer = solution(people, limit);
		System.out.println(answer);
		
		int[] people1 = {70, 50, 80, 50};
		int limit1 = 100;
		int answer1 = solution1(people1, limit1);
		System.out.println(answer1);
	}
	
	public static int solution(int[] people,int limit){
		List<Integer> arrayList = new ArrayList<>();

		int answer=0;

		for(int temp:people){
			arrayList.add(temp);
		}
		
		// sort의 경우 ArrayList가 빠름
		arrayList.sort(null);
		
		List<Integer> linkedList = new LinkedList<>(arrayList);
		
		int tempLimit;

		while(!linkedList.isEmpty()){
			int length = linkedList.size()-1;
			
			// 삽입, 삭제의 경우 LinkedList가 빠름
			tempLimit = limit-linkedList.get(length);
			linkedList.remove(length);
	
			for(int i=0; i<linkedList.size(); i++){
				int temp=linkedList.get(i);
				
				if(temp<=tempLimit){
					tempLimit-=temp;
					linkedList.remove(i);
				}else {
					break;
				}
			}
			
			answer++;
		}
		
		return answer;
	}
	
	// 다른 사람의 풀이 참고
	public static int solution1(int[] people,int limit){
		// 정렬의 경우 리스트 변경하지 말고 바로 하는게 효율이 좋음
		Arrays.sort(people);
		
		int i = 0;
		int j = people.length-1;
		
		while(i<j) {
			// 큰값에서 작은 것들 더하는 형식으로 구성 - 최대 두명 제한이기에 성립
			if(people[i] + people[j] <= limit) {
				i++;
			}
			j--;
		}
		
		return people.length - i;
	}
}
