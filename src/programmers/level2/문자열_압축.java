package programmers.level2;

public class 문자열_압축 {
	public static void main(String args[]) {
		String s = "ababcdcdababcdcd";
		int answer = solution(s);
		System.out.println(answer);
		
		String s1 = "ababcdcdababcdcd";
		int answer1 = solution1(s1);
		System.out.println(answer1);
	}

	public static int solution(String s) {
		int answer = s.length();
		int count =1;
		
		String pattern = "";
		int patternCount =0;
		
		while(count<=s.length()){
			int length = s.length();
			for(int i=0;i<s.length();i=i+count){
					if(i+count <= s.length()){
						if(pattern.equals(s.substring(i, i+count))){
							length -= count;
							
							// 패턴 반복 횟수를 기록 - 2이상일 경우부터 기록 시작 
							patternCount++; 
							if(patternCount==2){
								length++;
							}else if(patternCount==10){
								length++;
							}else if(patternCount==100){
								length++;
							}else if(patternCount==1000){
								length++;
							}
						}else{
							// 패턴 변경
							pattern =s.substring(i , i+count);
							patternCount=1;
						}
					}
			}
			answer =Math.min(answer,length);
			count++;
		}
		return answer;
	}
	
	// 다른 사람의 풀이 참고
	public static int solution1(String s) {
		int answer = s.length();
		
		for(int i=1; i<s.length()/2+1; i++) {
			int result = split(s, i, 1);
			answer=Math.min(answer, result);
		}
		
		return answer;
	}

	private static int split(String s, int index, int patternCount) {
		if(s.length()<index) {
			return s.length();
		}
		
		String preString = s.substring(0, index);
		String postString = s.substring(index, s.length());
		
		if(!postString.startsWith(preString)) {
			if(patternCount==1) {
				return index+split(postString, index, 1);
			}else {
				return Integer.toString(patternCount).length()+index+split(postString, index, 1);
			}
		}
		
		return split(postString, index, patternCount+1);
	}
}
