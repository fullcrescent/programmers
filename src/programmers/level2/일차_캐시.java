package programmers.level2;

import java.util.LinkedList;
import java.util.List;

public class 일차_캐시 {
	public static void main(String[] args) {
		int cachSize = 3;
		String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
		int answer = solution(cachSize, cities);
		System.out.println(answer);
	}
	
	public static int solution(int cacheSize, String[] cities) {
		List<String> list = new LinkedList<>();
		
		int answer = 0 ;
		int cacheHit = 1;
		int cacheMiss = 5;
		
		for(String temp : cities) {
			temp = temp.toLowerCase();
			
			if(list.remove(temp)) {
				answer += cacheHit;
				list.add(0, temp);
			}else {
				answer += cacheMiss;
				list.add(0, temp);
				
				if(list.size()>cacheSize) {
					list.remove(list.size()-1);
				}
			}
		}
		
        return answer;
    }

}
