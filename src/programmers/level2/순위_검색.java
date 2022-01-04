package programmers.level2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		
		StringBuilder sb = new StringBuilder();
		
		for(String temp : info) {
			sb.append(temp);
		}
		
		Pattern pattern = Pattern.compile("[^*+-][0-9]*$");
		Matcher matcher;
		
		for(String temp : query) {
			String[] queryInfo = temp.replaceAll("and ", "").split(" ");
			String a = (queryInfo[0].equals("-") ? "[a-z]* " : queryInfo[0] + " ") +
					(queryInfo[1].equals("-") ? "[a-z]* " : queryInfo[1] + " ") +
					(queryInfo[2].equals("-") ? "[a-z]* " : queryInfo[2] + " ") +
					(queryInfo[3].equals("-") ? "[a-z]* " : queryInfo[3] + " ") +
					"[0-9]*";
			pattern = Pattern.compile(
					(queryInfo[0].equals("-") ? "[a-z]* " : queryInfo[0] + " ") +
					(queryInfo[1].equals("-") ? "[a-z]* " : queryInfo[1] + " ") +
					(queryInfo[2].equals("-") ? "[a-z]* " : queryInfo[2] + " ") +
					(queryInfo[3].equals("-") ? "[a-z]* " : queryInfo[3] + " ") +
					"[0-9]*"
					);
					
			matcher = pattern.matcher(sb.toString());
			
			System.out.println(a);
			System.out.println(info);
			while(matcher.find()) {
				System.out.println(matcher.group());
			}
			
		}
		
		
		return answer;
	}

}
