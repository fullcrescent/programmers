package programmers.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 구명보트 {

	public static void main(String[] args) {
		int[] people = {70, 50, 80, 50};
		int limit = 100;
		int answer = solution(people, limit);
		System.out.println(answer);
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
}
