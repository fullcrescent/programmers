package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 일일공_옮기기 {
    public static void main(String[] args) {
        String[] s = {"1100111011101001"};
        String[] answer = solution(s);
        System.out.println(Arrays.toString(answer));
    }

    public static String[] solution(String[] s) {
        List<String> list = new ArrayList<>();

        for(String temp : s){
            StringBuilder add = new StringBuilder();
            Stack<Character> stack = new Stack<>();

            for(Character c : temp.toCharArray()){
                if(!stack.isEmpty() && stack.peek()=='1' && c=='0'){
                    stack.pop();

                    if(!stack.isEmpty() && stack.peek()=='1'){
                        stack.pop();
                        add.append("110");
                    }else{
                        stack.add('1');
                        stack.add(c);
                    }
                }else{
                    stack.add(c);
                }
            }

            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()){
                sb.insert(0, stack.pop());
            }

            sb.insert(sb.lastIndexOf("0")+1, add);

            list.add(sb.toString());
        }

        return list.toArray(String[]::new);
    }
}
