package programmers.level3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 표_편집 {

	public static void main(String[] args) {
		int n = 8;
		int k = 2;
		String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};
		String answer = solution(n, k, cmd);
		System.out.println(answer);
	}
	
	public static String solution(int n, int k, String[] cmd) {
		Stack<Integer> stack = new Stack<>();
		boolean[] remove = new boolean[n];

		List<Info> list = new ArrayList<>();
		Info info = new Info();

		for(int i=0; i<cmd.length-1; i++){
			char prev = cmd[i].charAt(0);
			char next = cmd[i+1].charAt(0);

			if(prev=='U' || prev=='D'){
				if(next=='D' || next=='U'){
//					info.add(cmd[i+1]);
				}
			}else{
				list.add(info);
				info = new Info();
			}
		}

		int start = k;

		for(Info temp : list) {
			switch(temp.direction) {
				case 'U' :
					start = binarySearch(remove, 0, start-1, temp.value);

					break;
				case 'D' :
					start = binarySearch(remove, start+1, n, temp.value);

					break;
				case 'C' :
					stack.add(start);
					remove[start] = true;

					start = binarySearch(remove, start+1, n, temp.value);

					break;
				case 'Z' :
					remove[stack.pop()] = false;

					break;
			}
		}

		StringBuilder sb = new StringBuilder();

		for(int i=0; i<n; i++) {
			if(remove[i])	sb.append("X");
			else 			sb.append("O");
		}

		return sb.toString();
	}

	private static int binarySearch(boolean[] array, int left, int right, int value) {
		int mid = 0, index = 0, weight = 0, answer = 0;

		if(left==0) {
			index = right;
			weight = -1;
		}
		else{
			index = left;
			weight = 1;
		}

		while(left<=right){
			int count = 0;

			mid = (left+right)/2;

			for(int i=index; i!=mid+weight; i += weight) {
				if(i==array.length) return binarySearch(array, 0, left-2, value);

				if(!array[i]) count++;

				if(count==value) break;
			}

			if(weight==1) {
				if(count==value) {
					answer = mid;
					right = mid-1;
				}else {
					left = mid+1;
				}
			}else {
				if(count==value) {
					answer = mid;
					left = mid+1;
				}else {
					right = mid-1;
				}
			}
		}

		return answer;
	}

	static class Info{
		char direction;
		int value;

		public Info() {}


	}
}
