package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 순위_검색 {

	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150"
				,"python frontend senior chicken 210"
				,"python frontend senior chicken 150"
				,"cpp backend senior pizza 260"
				,"java backend junior chicken 80"
				,"python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100"
				,"python and frontend and senior and chicken 200"
				,"cpp and - and senior and pizza 250"
				,"- and backend and senior and - 150"
				,"- and - and - and chicken 100"
				,"- and - and - and - 150"};
		int answer[] = solution(info, query);
		System.out.println(Arrays.toString(answer));
	}

	public static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		List<String> list = Arrays.asList(info);
		
		list.sort(Comparator.comparingInt((i)->Integer.parseInt(i.replaceAll("[a-z ]", ""))));
		
		return answer;
	}

}
