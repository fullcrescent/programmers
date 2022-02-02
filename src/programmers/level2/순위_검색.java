package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class 순위_검색 {

	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150"
				,"python frontend senior chicken 210"
				,"python frontend senior chicken 150"
				,"cpp backend senior pizza 260"
				,"java backend junior pizza 80"
				,"python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100"
				,"python and frontend and senior and chicken 200"
				,"cpp and - and senior and pizza 250"
				,"- and backend and senior and - 150"
				,"- and - and - and chicken 100"
				,"- and - and - and - 150"};
		int answer[] = solution(info, query);
		System.out.println(Arrays.toString(answer));
		
		String[] info1 = {"java backend junior pizza 150"
				,"python frontend senior chicken 210"
				,"python frontend senior chicken 150"
				,"cpp backend senior pizza 260"
				,"java backend junior pizza 80"
				,"python backend senior chicken 50"};
		String[] query1 = {"java and backend and junior and pizza 100"
				,"python and frontend and senior and chicken 200"
				,"cpp and - and senior and pizza 250"
				,"- and backend and senior and - 150"
				,"- and - and - and chicken 100"
				,"- and - and - and - 150"};
		int answer1[] = solution1(info1, query1);
		System.out.println(Arrays.toString(answer1));
	}

	public static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		Map<String, List<Integer>> map = new HashMap<>();
		
		for(String temp : info) {
			int index = temp.lastIndexOf(" "); 
			
			String key = temp.substring(0, index);
			int value = Integer.valueOf(temp.substring(index+1, temp.length()));
			
			if(map.get(key) == null) {
				List<Integer> list = new ArrayList<>();
				list.add(value);
				map.put(temp.substring(0, index), list);
			}else {
				map.get(key).add(value);
			}
		}
		
		Iterator<String> iter = map.keySet().iterator();
		
		while(iter.hasNext()) {
			map.get(iter.next()).sort(null);
		}
		
		int index=0;
		
		for(String temp : query) {
			String[] tempValue = temp.replaceAll("and ", "").split(" ");
			answer[index++] = search(map, tempValue[0], tempValue[1], tempValue[2], tempValue[3], Integer.valueOf(tempValue[4]));
		}
		
		return answer;
	}
	
	private static int search(Map<String, List<Integer>> map, String language, String jobGroup, String career, String soulFood, int score) {
		if(language.equals("-")) {
			return search(map, "java", jobGroup, career, soulFood, score)
					+ search(map, "cpp", jobGroup, career, soulFood, score)
					+ search(map, "python", jobGroup, career, soulFood, score);
		}else if(jobGroup.equals("-")) {
			return search(map, language, "frontend", career, soulFood, score)
					+ search(map, language, "backend", career, soulFood, score);
		}else if(career.equals("-")) {
			return search(map, language, jobGroup, "junior", soulFood, score)
					+ search(map, language, jobGroup, "senior", soulFood, score);
		}else if(soulFood.equals("-")) {
			return search(map, language, jobGroup, career, "chicken", score)
					+ search(map, language, jobGroup, career, "pizza", score);
		}else {
			List<Integer> list = map.get(language + " " + jobGroup + " " + career + " " + soulFood);
			if(list == null) {
				return 0;
			}
				
			int start =0;
			int end = list.size()-1;
			
			while(start<=end) {
				int mid = (start+end)/2;
				
				if(list.get(mid)<score) {
					start=mid+1;
				}else {
					end=mid-1;
				}
			}
			
			return list.size()-start;
		}
	}
	
	// 다른 사람의 풀이 참고
	public static int[] solution1(String[] info, String[] query) {
		int[] answer = new int[query.length];
		
		String[] language = {"cpp", "java", "python"},
				jobGroup = {"frontend", "backend"},
				career = {"junior", "senior"},
				soulFood = {"chicken", "pizza"};
		
		Map<String, Map<String, Map<String, Map<String, List<Integer>>>>> map = new HashMap<>();
		
		for(String tempLanguage : language) {
			map.put(tempLanguage, new HashMap<>());
		}
		
		for(String tempLanguage : map.keySet()) {
			Map<String, Map<String, Map<String, List<Integer>>>> jobGroupMap = map.get(tempLanguage);
			for(String tempJobGroup : jobGroup) {
				jobGroupMap.put(tempJobGroup, new HashMap<>());
			}
			
			for(String tempJobGroup : jobGroupMap.keySet()) {
				Map<String, Map<String, List<Integer>>> carrerMap = jobGroupMap.get(tempJobGroup);
				for(String tempCarrer : career) {
					carrerMap.put(tempCarrer, new HashMap<>());
				}
				
				for(String tempCarrer : carrerMap.keySet()) {
					Map<String, List<Integer>> soulFoodMap = carrerMap.get(tempCarrer);
					for(String tempSoulFood : soulFood) {
						soulFoodMap.put(tempSoulFood, new ArrayList<Integer>());
					}
				}
			}
		}
		
		for(String temp : info) {
			String[] value = temp.split(" ");
			map.get(value[0]).get(value[1]).get(value[2]).get(value[3]).add(Integer.parseInt(value[4]));
		}
		
		for(Map<String, Map<String, Map<String, List<Integer>>>> temp0 : map.values())
			for(Map<String, Map<String, List<Integer>>> temp1 : temp0.values())
				for(Map<String, List<Integer>> temp2 : temp1.values())
					for(List<Integer> temp3 : temp2.values())
						temp3.sort(null);
		
		int index = 0;
		
		for(String temp : query) {
			String[] mapInfo = temp.replaceAll("and ", "").split(" ");
			int score = Integer.parseInt(mapInfo[4]);
			
			for(String tempLanguage : language) {
				if(mapInfo[0].equals("-") || mapInfo[0].equals(tempLanguage)) {
					Map<String, Map<String, Map<String, List<Integer>>>> jobGroupMap = map.get(tempLanguage);
					
					for(String tempJobGroup : jobGroup) {
						if(mapInfo[1].equals("-") || mapInfo[1].equals(tempJobGroup)) {
							Map<String, Map<String, List<Integer>>> carrerMap = jobGroupMap.get(tempJobGroup);
							
							for(String tempCareer : career) {
								if(mapInfo[2].equals("-") || mapInfo[2].equals(tempCareer)) {
									Map<String, List<Integer>> soulFoodMap = carrerMap.get(tempCareer);
									
									for(String tempSoulFood : soulFood) {
										if(mapInfo[3].equals("-") || mapInfo[3].equals(tempSoulFood)) {
											List<Integer> list = soulFoodMap.get(tempSoulFood);
											
											int start =0;
											int end = list.size()-1;
											
											while(start<=end) {
												int mid = (start+end)/2;
												
												if(list.get(mid)<score) {
													start=mid+1;
												}else {
													end=mid-1;
												}
											}
											
											answer[index] += list.size()-start;
										}
									}
								}
							}
						}
					}
				}
			}
			index++;
		}
		
		return answer;
	}
}
