package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 파일명_정렬 {

	public static void main(String[] args) {
		String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		String[] answer = solution(files);
		System.out.println(Arrays.toString(answer));
		
		String[] files1 = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		String[] answer1 = solution1(files1);
		System.out.println(Arrays.toString(answer1));
	}
	
	public static String[] solution(String[] files) {
		Arrays.sort(files, new Comparator<String>() {
			Pattern pattern = Pattern.compile("[0-9]+");
			
			Matcher matcher1;
			Matcher matcher2;
			
			public int compare(String s1, String s2) {
				String[] head1 = s1.split("!*[0-9]");
				String[] head2 = s2.split("!*[0-9]");
				
				int head = head1[0].toLowerCase().compareTo(head2[0].toLowerCase());
				
				if(head!=0) {
					return head;
				}
				matcher1 = pattern.matcher(s1);
				matcher2 = pattern.matcher(s2);
				
				matcher1.find();
				matcher2.find();
				
				int number = Integer.parseInt(matcher1.group())- Integer.parseInt(matcher2.group());
				
				return number;
			}
		});
		
		return files;
	}
	
	// 다른 사람의 풀이 참고
	public static String[] solution1(String[] files) {
		Arrays.sort(files, new Comparator<String>() {
			public int compare(String s1, String s2) {
				s1 = s1.toLowerCase();
				s2 = s2.toLowerCase();
				
				int end1 = 0;
				int end2 = 0;
				
				while(end1<s1.length() && !Character.isDigit(s1.charAt(end1))) end1++;
				while(end2<s2.length() && !Character.isDigit(s2.charAt(end2))) end2++;
				
				int value = s1.substring(0,end1).compareTo(s2.substring(0, end2));
				
				if(value!=0) return value;
				
				int start1 = end1;
				int start2 = end2;
				
				while(end1<s1.length() && Character.isDigit(s1.charAt(end1))) end1++;
				while(end2<s2.length() && Character.isDigit(s2.charAt(end2))) end2++;
				
				return Integer.parseInt(s1.substring(start1, end1)) - Integer.parseInt(s2.substring(start2, end2));
			}
		});
		
		return files;
	}
}