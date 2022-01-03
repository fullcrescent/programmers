package programmers.level2;

import java.util.Arrays;

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
		
		Arrays.sort(info);
		
		int index=0;
		
		for(String temp : query) {
			String[] tempValue = temp.replaceAll("and ", "").split(" ");
			answer[index++] = search(info, tempValue[0], tempValue[1], tempValue[2], tempValue[3], Integer.valueOf(tempValue[4]));
		}
		
		return answer;
	}
	
	private static int search(String[] info, String language, String jobGroup, String career, String soulFood, int score) {
		if(language == "-") {
			return search(info, "java", jobGroup, career, soulFood, score)
					+ search(info, "cpp", jobGroup, career, soulFood, score)
					+ search(info, "python", jobGroup, career, soulFood, score);
		}else if(jobGroup == "-") {
			return search(info, language, "frontend", career, soulFood, score)
					+ search(info, language, "backend", career, soulFood, score);
		}else if(career == "-") {
			return search(info, language, jobGroup, "junior", soulFood, score)
					+ search(info, language, jobGroup, "senior", soulFood, score);
		}else if(soulFood == "-") {
			return search(info, language, jobGroup, career, "chicken", score)
					+ search(info, language, jobGroup, career, "pizza", score);
		}else {
			boolean flag = false;
			int value =0;
			for(int i=0; i<info.length; i++) {
				if(info[i].contains(language + " " + jobGroup + " " + career + " " + soulFood) && Integer.valueOf(info[i].split(" ")[4]) >= score) {
					flag=true;
					value++;
				}
				
				if(flag) {
					break;
				}
			}
			return value;
		}
	}
}

