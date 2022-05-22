package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class 베스트앨범 {

	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic","jazz","pop", "Rock", "jazz"};
		int[] plays = {500, 600, 150, 800, 1100, 2500, 100, 1000};
		int[] answer = solution(genres, plays);
		System.out.println(Arrays.toString(answer));
		
		String[] genres1 = {"classic", "pop", "classic", "classic","jazz","pop", "Rock", "jazz"};
		int[] plays1 = {500, 600, 150, 800, 1100, 2500, 100, 1000};
		int[] answer1 = solution1(genres1, plays1);
		System.out.println(Arrays.toString(answer1));
	}
	
	public static int[] solution(String[] genres, int[] plays) {
		Map<String, Map<Integer, Integer>> map = new HashMap<>();
		
		List<Integer> answerList = new LinkedList<>(); 
		
		for(int i=0; i<genres.length; i++) {
			if(map.get(genres[i])==null) {
				Map<Integer, Integer> tempMap = new HashMap<>();
				tempMap.put(i, plays[i]);
				map.put(genres[i], tempMap);
			}else {
				map.get(genres[i]).put(i, plays[i]);
			}
		}
		
		List<String> genresList = new ArrayList<>(map.keySet());
		
		Collections.sort(genresList, new Comparator<String>(){
			public int compare(String s1, String s2) {
				long temp1 = 0;
				Map<Integer, Integer> map1 = map.get(s1);
				for(int key1 : map1.keySet()) {
					temp1 += map1.get(key1);
				}
				
				long temp2 = 0;
				Map<Integer, Integer> map2 = map.get(s2);
				for(int key2 : map2.keySet()) {
					temp2 += map2.get(key2);
				}
				
				return -Long.compare(temp1, temp2);
			}
		});
		
		for(String key : genresList) {
			List<Integer> playsList = new ArrayList<>(map.get(key).keySet());
			
			Collections.sort(playsList, new Comparator<Integer>() {
				public int compare(Integer i1, Integer i2) {
					Map<Integer, Integer> tempMap = map.get(key);
					return -Integer.compare(tempMap.get(i1), tempMap.get(i2));
				}
			});
			
			answerList.add(playsList.get(0));
			if(playsList.size()>1) {
				answerList.add(playsList.get(1));
			}
		}
		
		return answerList.stream().mapToInt(i->i).toArray();
	}

	// 다른 사람의 풀이 참고
	public static int[] solution1(String[] genres, int[] plays) {
		return IntStream.range(0, genres.length)
				.mapToObj(i -> new Music(i, plays[i], genres[i]))
				.collect(Collectors.groupingBy(Music::getGenre))
				.entrySet().stream()
				.sorted((i1, i2) -> sum(i2.getValue()) - sum(i1.getValue()))
				.flatMap(i->i.getValue().stream().sorted().limit(2))
				.mapToInt(i->i.id).toArray();
	}
	
	private static int sum(List<Music> music) {
		int answer = 0;
		
		for(Music temp : music)	answer += temp.played;
		
		return answer;
	}

	public static class Music implements Comparable<Music> {
		private int id;
		private int played;
		private String genre;
		
		public Music(int id, int played, String genre) {
			this.id  = id;
			this.played = played;
			this.genre = genre;
		}

		public String getGenre() {
			return genre;
		}
		
		@Override
		public int compareTo(Music input) {
			if(this.played == input.played) {
				return this.id-input.id;
			}
			
			return input.played-this.played;
		}
	}
}
