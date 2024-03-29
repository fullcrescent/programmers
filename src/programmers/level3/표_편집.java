package programmers.level3;

import java.util.Stack;

public class 표_편집 {

	public static void main(String[] args) {
		int n = 8;
		int k = 2;
		String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "C", "U 2", "Z", "Z", "U 1", "C"};
		String answer = solution(n, k, cmd);
		System.out.println(answer);

		int n1 = 8;
		int k1 = 2;
		String[] cmd1 = {"D 2", "C", "U 3", "C", "D 4", "C", "C", "U 2", "Z", "Z", "U 1", "C"};
		String answer1 = solution1(n1, k1, cmd1);
		System.out.println(answer1);


		int n3 = 8;
		int k3 = 2;
		String[] cmd3 = {"D 2", "C", "U 3", "C", "D 4", "C", "C", "U 2", "Z", "Z", "U 1", "C"};
		String answer3 = solution3(n3, k3, cmd3);
		System.out.println(answer3);
	}

	/*질문하기의 아이디어로 풀이*/
	public static String solution(int n, int k, String[] cmd) {
		CellList list = new CellList(n);

		for(int i=1; i<n; i++){
			list.add(i);
		}

		Stack<Integer> stack = new Stack<>();
		Cell cCell = list.get(k);

		for (String s : cmd) {
			char c = s.charAt(0);

			switch (c) {
				case 'U':
					cCell = prev(cCell, Integer.parseInt(s.split(" ")[1]));

					break;
				case 'D':
					cCell = next(cCell, Integer.parseInt(s.split(" ")[1]));

					break;
				case 'C':
					stack.add(cCell.value);

					if(cCell.prev!=null){
						cCell.prev.next = cCell.next;
					}

					if(cCell.next!=null){
						cCell.next.prev = cCell.prev;
						cCell = cCell.next;
					}else{
						cCell = cCell.prev;
					}

					break;
				case 'Z':
					Cell zCell = list.get(stack.pop());

					if(zCell.prev!=null)	zCell.prev.next = zCell;
					if(zCell.next!=null)	zCell.next.prev = zCell;

					break;
			}
		}

		StringBuilder sb = new StringBuilder("O".repeat(n));

		while(!stack.isEmpty()){
			int temp = stack.pop();
			sb.replace(temp, temp+1, "X");
		}

		return sb.toString();
	}

	private static Cell prev(Cell cCell, int i) {
		Cell temp = cCell;
		int count = 0;

		while(count++<i){
			temp = temp.prev;
		}

		return temp;
	}

	private static Cell next(Cell cCell, int i) {
		Cell temp = cCell;
		int count = 0;

		while(count++<i){
			temp = temp.next;
		}

		return temp;
	}

	static class Cell{
		Cell prev = null;
		Cell next = null;
		int value;

		public Cell(int value) {
			this.value = value;
		}
	}

	static class CellList{
		private final Cell[] array;

		public CellList(int n) {
			Cell root = new Cell(0);
			array = new Cell[n];
			array[0] = root;
		}

		public void add(int value){
			array[value] = new Cell(value);

			array[value-1].next = array[value];
			array[value].prev = array[value-1];
		}

		public Cell get(int i){
			return array[i];
		}
	}

	/*효율성 8번 시관초과로 오답*/
	public static String solution3(int n, int k, String[] cmd) {
		Stack<Integer> stack = new Stack<>();
		boolean[] remove = new boolean[n];

		int start = k;

		int value = 0;

		for (String s : cmd) {
			char c = s.charAt(0);

			switch (c) {
				case 'U':
					value -= Integer.parseInt(s.split(" ")[1]);

					break;
				case 'D':
					value += Integer.parseInt(s.split(" ")[1]);

					break;
				case 'C':
					if (value < 0) {
						start = binarySearch3(remove, 0, start - 1, -value);
					} else if (value > 0) {
						start = binarySearch3(remove, start + 1, n, value);
					}
					value = 0;

					stack.add(start);
					remove[start] = true;

					start = binarySearch3(remove, start + 1, n, 1);

					break;
				case 'Z':
					if (value < 0) {
						start = binarySearch3(remove, 0, start - 1, -value);
					} else if (value > 0) {
						start = binarySearch3(remove, start + 1, n, value);
					}
					value = 0;

					remove[stack.pop()] = false;

					break;
			}
		}

		StringBuilder sb = new StringBuilder("O".repeat(n));

		while(!stack.isEmpty()){
			int temp = stack.pop();
			sb.replace(temp, temp+1, "X");
		}

		return sb.toString();
	}

	private static int binarySearch3(boolean[] array, int left, int right, int value) {
		int mid, index, weight, answer = 0;

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
				if(i==array.length) return binarySearch3(array, 0, left-2, value);

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

	/*다른 사람의 풀이 참고*/
	public static String solution1(int n, int k, String[] cmd) {
		int size = n;
		Stack<Integer> stack = new Stack<>();

		for (String s : cmd) {
			char c = s.charAt(0);

			switch (c) {
				case 'U':
					k -= Integer.parseInt(s.split(" ")[1]);
					if(k<0)	k = 0;

					break;
				case 'D':
					k += Integer.parseInt(s.split(" ")[1]);
					if(k>size-1)	k = size-1;

					break;
				case 'C':
					stack.add(k);
					size--;
					if(k==size)	k--;

					break;
				case 'Z':
					if(k>=stack.pop())	k++;
					size++;

					break;
			}
		}

		StringBuilder sb = new StringBuilder("O".repeat(size));

		while(!stack.empty()){
			sb.insert(stack.pop().intValue(),'X');
		}

		return sb.toString();
	}
}
